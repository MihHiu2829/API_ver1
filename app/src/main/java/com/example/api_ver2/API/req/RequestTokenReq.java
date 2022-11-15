package com.example.api_ver2.API.req;

import com.google.gson.annotations.SerializedName;

public class RequestTokenReq {

    @SerializedName("request_Token")

    public String requesttoken ;

    public RequestTokenReq( String requesttoken) {
        this.requesttoken = requesttoken;
    }
}
