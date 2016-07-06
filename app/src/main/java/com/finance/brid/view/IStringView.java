package com.finance.brid.view;

import com.finance.brid.ui.http.RequestUrl;

/**
 * Created by admin on 2016/6/30.
 */
public interface IStringView {
    RequestUrl getRequestUrl();
    void onResponse(String response);
}
