package com.wu.utils.okhttp.callback;

import okhttp3.Response;

/**
 * Created by admin on 2016/6/29.
 * 返回字符串类型的数据
 */
public abstract class StringCallback extends AbsCallback<String> {

    @Override
    public String parseNetworkResponse(Response response) throws Exception {
        return response.body().string();
    }

}
