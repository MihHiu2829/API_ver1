package com.example.api_ver2.API;




import com.example.api_ver2.API.req.AccountReq;
import com.example.api_ver2.API.req.RequestTokenReq;
import com.example.api_ver2.API.res.AuthenRes;
import com.example.api_ver2.API.res.SessionRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    static String APIkey = "adee871a78e5736c792ff131a3a29566" ;
    @GET("authentication/token/new?api_key=" + APIkey )
    @Headers("Content-Type: application/json")
    Call<AuthenRes> GetAuthen() ;


    @POST("authentication/token/validate_with_login?api_key=" + APIkey )
    @Headers("Content-Type: application/json")
    Call<AuthenRes> createSession(@Body AccountReq acc) ;




    @POST("authentication/session/new?api_key=" + APIkey )
    @Headers("Content-Type: application/json")
    Call<SessionRes > createSessinID(@Body RequestTokenReq acc) ;



}
