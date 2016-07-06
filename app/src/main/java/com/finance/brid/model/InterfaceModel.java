package com.finance.brid.model;

import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.http.callback.StringDialogCallback;
import com.wu.utils.okhttp.callback.StringCallback;

/**
 * Created by admin on 2016/6/29.
 */
public class InterfaceModel {
    public interface postModel{
        void postData(RequestUrl requestUrl, StringDialogCallback callback);
    }
    public interface getModel{
        void getData(RequestUrl requestUrl, StringCallback callback);
    }
}
