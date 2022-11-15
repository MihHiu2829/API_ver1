package com.example.api_ver2.ViewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.api_ver2.API.API;
import com.example.api_ver2.OnAPICallBack;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Common_VM extends ViewModel{
        public static final String BASE_URL = "https://api.themoviedb.org/3/";
        public static final String TAG = Common_VM.class.getName();
        protected OnAPICallBack callBack ;

        public void setCallBack(OnAPICallBack callBack)
        {
                this.callBack = callBack ;
        }

        protected final API getAPI()
        {
        Retrofit rs=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .client(new OkHttpClient.Builder().callTimeout(30,TimeUnit.SECONDS).build()).build();
        return rs.create(API.class);

        }
        protected  <T> Callback<T> initHandleResponse(String key) {
                return new Callback<T>() {
                        @Override
                        public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                                if(response.code() == 200 || response.code() == 201)
                                {
                                        assert response.body() != null;
                                        handleSuccess(key,response.body()) ;
                                }else
                                {
                                        handleFail(key,response.code(),response.errorBody()) ;
                                }
                        }

                        @Override
                        public void onFailure(@NonNull Call<T> call,@NonNull Throwable t) {
                                Log.e(TAG,"onFailrue: "+ t.getMessage()) ;
                                handleException(key,t) ;

                        }
                };
        }
        protected void handleException(String key, Throwable t) {
                        callBack.apiError(key,999,t.getMessage());
        }

        protected void handleFail(String key, int code, ResponseBody responseBody) {
                Log.e(TAG,"handleFail: "+ code) ;
               callBack.apiError(key,code,responseBody);
        }

        protected void handleSuccess(String key,Object body) {
           //do nothing

                callBack.apiSuccess(key,body);
        }


}
