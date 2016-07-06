package com.finance.brid.ui.http.callback;

import com.wu.utils.okhttp.callback.AbsCallback;
import com.wu.utils.okhttp.request.BaseRequest;

/**
 * Created by admin on 2016/7/1.
 * 该类主要用于在所有请求之前添加公共的请求头或请求参数，例如登录授权的 token,使用的设备信息等
 */
public abstract class CommonCallback<T> extends AbsCallback<T> {
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //如果账户已经登录，就添加 token 等等
//        request.params("access_token", "");
    }
}
