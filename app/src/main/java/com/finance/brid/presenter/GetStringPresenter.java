package com.finance.brid.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.finance.brid.model.GetModel;
import com.finance.brid.model.InterfaceModel;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.view.IStringView;
import com.wu.utils.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2016/6/30.
 */
public class GetStringPresenter {
    private InterfaceModel.getModel getModel;
    private IStringView iStringView;
    private String tag;
    private Context mContext;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            iStringView.onResponse(msg.obj.toString());
        }
    };

    public GetStringPresenter(Context mContext, IStringView iStringView) {
        getModel = new GetModel();
        this.iStringView = iStringView;
        this.mContext = mContext;
    }

    public void getData() {
        getModel.getData(iStringView.getRequestUrl(), new StringCallback() {
            @Override
            public String parseNetworkResponse(Response response) throws Exception {
                return super.parseNetworkResponse(response);
            }

            @Override
            public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
                LogUtils.i(response.code() + "");
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
