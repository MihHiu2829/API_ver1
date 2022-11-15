package com.example.api_ver2.ViewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.* ;

import com.example.api_ver2.API.API;
import com.example.api_ver2.API.req.AccountReq;
import com.example.api_ver2.API.req.RequestTokenReq;
import com.example.api_ver2.API.res.AuthenRes;
import com.google.gson.internal.GsonBuildConfig;


import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class m000_mainVM extends Common_VM {
    public static final String TAG = m000_mainVM.class.getName() ;
    public static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    public static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    public static final String KEY_API_CREATE_SESSIONID = "KEY_API_CREATE_SESSIONID";


    private String username , password ;

    public void getAuthen(String username, String password)
        {
////            new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() ;
//         Retrofit rs =    new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
//           .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build()).build() ;
//

//            API api = rs.create(API.class) ;
            this.username = username ;
            this.password = password ;
            getAPI().GetAuthen().enqueue(initHandleResponse(KEY_API_AUTHEN));

        }



    private void createSession(String requesttoken) {
        getAPI().createSession(new AccountReq(username,password,requesttoken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSION));

    }
    private void createSessionID(String requesttoken) {
        getAPI().createSessinID(new RequestTokenReq(requesttoken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSIONID));

    }


    @Override
    protected void handleSuccess(String key, Object body) {
        Log.i(TAG,"handleSuccess: "+ key) ;
        Log.i(TAG,"handleSuccess: "+ body) ;
        switch (key) {
            case KEY_API_AUTHEN:
                createSession(((AuthenRes) body).requesttoken);
                break;
            case KEY_API_CREATE_SESSION:
                createSessionID(((AuthenRes) body).requesttoken);

                break;
            case KEY_API_CREATE_SESSIONID:
                callBack.apiSuccess(key, body);
                //go to UI
                break;
        }
    }




}
