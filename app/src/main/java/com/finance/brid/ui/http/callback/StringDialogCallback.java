package com.finance.brid.ui.http.callback;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.finance.brid.ui.utils.NetUtils;
import com.finance.brid.ui.views.LoadingView;
import com.wu.utils.okhttp.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by admin on 2016/7/1.
 */
public abstract class StringDialogCallback extends EncryptCallback<String> {
    private LoadingView loadingView;
    private Context mContext;

    public StringDialogCallback(Context mContext) {
        this.mContext = mContext;
        loadingView = LoadingView.createLoadingDialog(mContext);
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        if (loadingView != null && !loadingView.isShowing()) {
            loadingView.show();
        }
        if(!NetUtils.isNetworkAvailable(mContext)){
            Toast.makeText(mContext, "网络断开，请检查网络！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String parseNetworkResponse(Response response) throws Exception {
        return response.body().string();
    }

    @Override
    public void onAfter(boolean isFromCache, @Nullable String s, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onAfter(isFromCache, s, call, response, e);
        if (loadingView != null && loadingView.isShowing()) {
            loadingView.dismiss();
        }
    }
}
