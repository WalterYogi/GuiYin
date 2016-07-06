package com.finance.brid.model;

import com.finance.brid.ui.http.RequestUrl;
import com.wu.utils.okhttp.OkHttpUtils;
import com.wu.utils.okhttp.callback.StringCallback;

/**
 * Created by admin on 2016/6/30.
 */
public class GetModel implements InterfaceModel.getModel  {
    @Override
    public void getData(RequestUrl requestUrl, StringCallback callback) {
        OkHttpUtils.get(requestUrl.url).tag(requestUrl.tag).params(requestUrl.getParams()).execute(callback);
    }
}
