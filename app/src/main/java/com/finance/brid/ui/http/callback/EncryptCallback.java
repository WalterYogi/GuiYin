package com.finance.brid.ui.http.callback;

import com.wu.utils.okhttp.request.BaseRequest;

/**
 * Created by admin on 2016/7/1.
 * 该类主要用于对所有的网络请求进行加密，防止拦截数据包进行篡改
 */
public abstract class EncryptCallback<T> extends CommonCallback<T> {
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
    }
}
