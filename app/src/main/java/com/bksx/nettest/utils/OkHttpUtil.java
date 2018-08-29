package com.bksx.nettest.utils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by try on 2018/5/8.
 */

public class OkHttpUtil {

    private static final OkHttpClient client = new OkHttpClient();

    private static Request getRequest(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }

    private static Response getResponse(String url) throws IOException {
        Response response = client.newCall(getRequest(url)).execute();
        if (response.isSuccessful()){
            return response;
        }
        return null;
    }

    public static void doAsycGet(String url, Callback callback){
        client.newCall(getRequest(url)).enqueue(callback);
    }

    private static Request getPostRequest(String url, RequestBody requestBody){
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }

    private static RequestBody getFormRequestBody(Map<String,String> formMap){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (formMap != null && !formMap.isEmpty()) {
            for (Map.Entry<String,String> entry:formMap.entrySet()){
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return formBodyBuilder.build();


    }

    private static void postRequestBodyAsync(String url,RequestBody requestBody,Callback callback){
        Request request = getPostRequest(url, requestBody);
        client.newCall(request).enqueue(callback);
    }

    private static void postKeyValueAsync(String url,Map<String,String> map,Callback callback){
        postRequestBodyAsync(url,getFormRequestBody(map),callback);
    }
}
