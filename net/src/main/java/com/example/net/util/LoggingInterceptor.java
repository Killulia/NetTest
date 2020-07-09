package com.example.net.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {
    private final int byteCount = 1024*1024;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //chain里面包含了request和response，按需获取
        Request request = chain.request();

        Response response = chain.proceed(request);

        Log.d("ccg",String.format("发送请求  %s",request.url()));

        ResponseBody responseBody = response.peekBody(byteCount);

        Log.d("ccg",String.format("接收响应  %s", responseBody.string()));

        return response;
    }
}
