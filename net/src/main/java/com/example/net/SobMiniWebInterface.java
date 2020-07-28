package com.example.net;

import com.example.net.bean.LoginResponse;

import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SobMiniWebInterface {

    @FormUrlEncoded
    @POST("qxydcjjk/login/login")
    Call<LoginResponse> getLoginResponse(@FieldMap Map<String,String> paramsMap);

}
