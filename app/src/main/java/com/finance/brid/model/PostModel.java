package com.finance.brid.model;

import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.http.callback.StringDialogCallback;
import com.wu.utils.okhttp.OkHttpUtils;

/**
 * Created by admin on 2016/6/29.
 */
public class PostModel implements InterfaceModel.postModel {
    @Override
    public void postData(RequestUrl requestUrl, StringDialogCallback callback) {
        OkHttpUtils.post(requestUrl.url).tag(requestUrl.tag).params(requestUrl.getParams()).execute(callback);
    }
}
