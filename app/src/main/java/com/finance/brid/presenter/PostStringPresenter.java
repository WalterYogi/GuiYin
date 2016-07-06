package com.finance.brid.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.finance.brid.model.InterfaceModel;
import com.finance.brid.model.PostModel;
import com.finance.brid.ui.http.callback.StringDialogCallback;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.view.IStringView;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2016/6/30.
 */
public class PostStringPresenter {
    private InterfaceModel.postModel postModel;
    private IStringView iStringView;
    private String tag;
    private Context mContext;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj == null) {
                iStringView.onResponse("");
            } else {
                iStringView.onResponse(msg.obj.toString());
            }
        }
    };

    public PostStringPresenter(Context mContext, IStringView iStringView) {
        postModel = new PostModel();
        this.iStringView = iStringView;
        this.mContext = mContext;
    }

    public void getData() {
        postModel.postData(iStringView.getRequestUrl(), new StringDialogCallback(mContext) {

            @Override
            public String parseNetworkResponse(Response response) throws Exception {
                return super.parseNetworkResponse(response);
            }

            @Override
            public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
                LogUtils.i(response.code() + "");
                    LogUtils.i("返回值：" + s);
                if (response.code() == 200) {
                    Message message = handler.obtainMessage();
                    message.obj = s;
                    handler.sendMessage(message);
                } else {
                    handlerError(response);
                }
            }

            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                super.onError(isFromCache, call, response, e);
            }

        });
    }

    private void handlerError(Response response) {
        Toast.makeText(mContext, "服务器发生" + response.code() + "错误", Toast.LENGTH_SHORT).show();
    }

}
