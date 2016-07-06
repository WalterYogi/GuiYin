package com.finance.brid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.finance.brid.Api;
import com.finance.brid.R;
import com.finance.brid.entity.Base;
import com.finance.brid.presenter.GetStringPresenter;
import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.utils.AppUtils;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.ui.utils.SPUtils;
import com.finance.brid.ui.utils.TimeUtils;
import com.finance.brid.view.IStringView;
import com.wu.utils.okhttp.model.HttpParams;


/**
 * Created by admin on 2016/5/16.
 */
public class StartActivity extends BaseActivity {
    private ImageView imgStart;
    private boolean isExits;
    private GetStringPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_layout);
        isExits = SPUtils.getBoolean(mContext, "first");
        imgStart = (ImageView) findViewById(R.id.img_start);
        setImageView();
        presenter = new GetStringPresenter(mContext, iStringView);
        presenter.getData();

    }

    public void setImageView() {
        imgStart.setImageResource(R.drawable.start);
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.activity_start_enter);
        imgStart.setAnimation(animation);
    }

    private void myTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity();
            }
        }, 2000);
    }

    private void startActivity() {
        if (isExits) {
            startActivity(new Intent(mContext, MainActivity.class));
        } else {
            startActivity(new Intent(mContext, GuideActivity.class));
            SPUtils.putBoolean(mContext, "first", true);
        }
        finish();
    }

    private IStringView iStringView = new IStringView() {
        @Override
        public RequestUrl getRequestUrl() {
            RequestUrl requestUrl = bindUrl(Api.BASE, AppUtils.getCurrentClassName());
            HttpParams params = requestUrl.getParams();
            params.put("access_token", "");
            return requestUrl;
        }

        @Override
        public void onResponse(String response) {
            Base base = gson.fromJson(response, Base.class);
            if (!SPUtils.contains(mContext, "next_pull_time") || (TimeUtils.getLongSysTime() - SPUtils.getLong(mContext, "next_pull_time")) > base.getNext_pull_time()) {
                SPUtils.putLong(mContext, "next_pull_time", TimeUtils.getLongSysTime());
                SPUtils.putString(mContext, "schema", base.getServers().get(0).getSchema());
                SPUtils.putString(mContext, "host", base.getServers().get(0).getHost());
                SPUtils.putInt(mContext, "port", base.getServers().get(0).getPort());
                SPUtils.putString(mContext, "version", base.getServers().get(0).getVersion());
                SPUtils.putString(mContext, "url", splitUrl());
            }
            myTimer();
            LogUtils.i(response + "");
        }
    };
}
