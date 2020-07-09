package com.example.net.util;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder= request.newBuilder();
        builder.addHeader("sessionConf", Constans.SEESSION);
        Log.d("ccg","HeaderInterceptor");
        return chain.proceed(builder.build());
    }
}
