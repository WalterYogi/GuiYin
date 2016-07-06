package com.finance.brid.ui.http;

import com.wu.utils.okhttp.model.HttpHeaders;
import com.wu.utils.okhttp.model.HttpParams;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by admin on 2016/5/31.
 */
public class RequestUrl {
    public String tag;
    public String url;
    public HttpHeaders heads;
    public HttpParams params;

    public RequestUrl(String url, String tag) {
        heads = new HttpHeaders();
        params = new HttpParams();
        this.url = url;
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpParams getParams() {
        return params;
    }

    public void setParams(HttpParams params) {
        this.params = params;
    }

    public HttpHeaders getHeads() {
        return heads;
    }

    public void setHeads(HttpHeaders heads) {
        this.heads = heads;
    }
    /** 将传递进来的参数拼接成 url */
    public static String createUrlFromParams(String url, Map<String, String> params) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(url);
            if (url.indexOf('&') > 0 || url.indexOf('?') > 0) sb.append("&");
            else sb.append("?");
            for (Map.Entry<String, String> urlParams : params.entrySet()) {
                    String urlValue = URLEncoder.encode(urlParams.getValue(), "UTF-8");
                    sb.append(urlParams.getKey()).append("=").append(urlValue).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }
}
