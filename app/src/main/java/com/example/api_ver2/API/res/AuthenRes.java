package com.example.api_ver2.API.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthenRes implements Serializable {
    @SerializedName("success")
    public boolean success ;
    @SerializedName("expires_At")

    public String expires_at ;
    @SerializedName("request_Token")

    public String requesttoken ;


    @Override
    public String toString() {
        return "AuthenRes{" +
                "success=" + success +
                ", expires_at='" + expires_at + '\'' +
                ", requesttoken='" + requesttoken + '\'' +
                '}';
    }
}
