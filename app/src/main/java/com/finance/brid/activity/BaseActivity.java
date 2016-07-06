package com.finance.brid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.finance.brid.Api;
import com.finance.brid.App;
import com.finance.brid.R;
import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.utils.SPUtils;
import com.finance.brid.ui.utils.StringUtils;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2016/6/22.
 */
public class BaseActivity extends AppCompatActivity {

    protected BaseActivity mActivity;
    protected Context mContext;
    public App mApp;
    protected Toolbar mToolbar;
    private TextView tvToolBarTitle;
    public String BACK = "back";

    public Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        gson = new Gson();
    }

    /**
     * 初始化
     */
    private void init() {
        mActivity = this;
        mContext = this;
        mApp = (App) getApplication();
        mApp.mActivity = mActivity;
        mApp.mContext = mContext;
    }

    /**
     * 设置标题栏
     *
     * @param back
     * @param title
     */
    public void setToolBarMode(String back, String title) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolBarTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        setToolBarTitle(title);
        if (!StringUtils.isBlank(back)) {
            mToolbar.setNavigationIcon(R.drawable.back);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setToolBarTitle(String title) {
        tvToolBarTitle.setText(title == null ? "" : title);
    }

    public void setToolBarTitle(int ids) {
        tvToolBarTitle.setText(ids);
    }

    /**
     * 提示语
     *
     * @param content
     */
    public void longToast(String content) {
        Toast.makeText(mActivity, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 得到网络请求RequestUrl
     *
     * @param url
     * @return
     */
    public RequestUrl bindUrl(String url, String tag) {
        StringBuffer sb = new StringBuffer(Api.HOST);
        sb.append(url);
        RequestUrl requestUrl = new RequestUrl(sb.toString(), tag);
        return requestUrl;
    }
    /**
     * 得到网络请求RequestUrl
     *
     * @param url
     * @param addToken
     * @return
     */
    public RequestUrl bindUrl(String url, String tag, boolean addToken) {
        StringBuffer sb = new StringBuffer(SPUtils.getString(mContext, "url"));
        sb.append(url);
        RequestUrl requestUrl = new RequestUrl(sb.toString(), tag);
//
        if (addToken) {
            requestUrl.heads.put("token", mApp.token);
        }
        return requestUrl;
    }

    /**
     * 拼接url
     * @return
     */
    public String splitUrl(){
        StringBuilder url = new StringBuilder();
        url.append(SPUtils.getString(mContext, "schema"));
        url.append("://");
        url.append(SPUtils.getString(mContext, "host"));
        url.append(":");
        url.append(SPUtils.getInt(mContext, "port"));
        url.append("/");
        url.append(SPUtils.getString(mContext, "version"));
        url.append("/");
        return url.toString();
    }

    public void inFromRight() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void outToRight() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void handleError(boolean isFromCache, Call call, @Nullable Response response) {
        Request request = call.request();
    }

}
