package com.example.api_ver2;

public interface OnAPICallBack {
    void apiSuccess(String key, Object data) ;
    void apiError(String key, int code,Object data) ;
}
