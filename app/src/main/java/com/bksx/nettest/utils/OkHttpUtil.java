package com.bksx.nettest.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by try on 2018/5/8.
 */

public class OkHttpUtil {

    private static OkHttpClient client = null;

    public  static OkHttpClient getOkHttpSingletonInstance() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }

    private static Request getRequest(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }

    private static Response getResponse(String url) throws IOException {
        Response response = getOkHttpSingletonInstance().newCall(getRequest(url)).execute();
        if (response.isSuccessful()){
            return response;
        }
        return null;
    }

    public static void doAsycGet(String url, Callback callback){
        getOkHttpSingletonInstance().newCall(getRequest(url)).enqueue(callback);
    }

    private static Request getPostRequest(String url, RequestBody requestBody){
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }

    //构建JSON请求体
    private static RequestBody getJSONRequestBody(Map<String,String> formMap) throws JSONException {
        JSONObject object = new JSONObject();
        if (formMap != null && !formMap.isEmpty()) {
            for (Map.Entry<String,String> entry:formMap.entrySet()){
                object.put(entry.getKey(), entry.getValue());
            }
        }
        MediaType JSON = MediaType.parse("application/json");
        return RequestBody.create(JSON, String.valueOf(object));

    }



    //构建表单请求体
    private static RequestBody getFormRequestBody(Map<String,String> formMap){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (formMap != null && !formMap.isEmpty()) {
            for (Map.Entry<String,String> entry:formMap.entrySet()){
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return formBodyBuilder.build();

    }

    //构建多文件请求体
    public static RequestBody buildMultiPartBody(Map<String,String> formMap, File[] files,String[] fileNameKey){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        //键值对部分
        if (formMap != null) {
            for (Map.Entry<String, String> entry : formMap.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }

        //文件部分
        if (files != null && fileNameKey!=null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();
                builder.addFormDataPart(fileNameKey[i], fileName, RequestBody.create(MediaType.parse("application/octet-stream"),file));
            }
        }

        return builder.build();


    }

    /*
    单文件上传不带参数
     */
    public static void uploadSingleFile(String url,File file,Callback callback){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        postRequestBodyAsync(url,requestBody,callback);
    }

    public static void postRequestBodyAsync(String url,RequestBody requestBody,Callback callback){
        Request request = getPostRequest(url, requestBody);
        getOkHttpSingletonInstance().newCall(request).enqueue(callback);
    }

    public static void postKeyValueAsync(String url,Map<String,String> map,Callback callback){
        postRequestBodyAsync(url,getFormRequestBody(map),callback);
    }

    public static void postJSONAsync(String url, HashMap<String, String> map,Callback callback) throws JSONException {
        Request request = getPostRequest(url, getJSONRequestBody(map));
        getOkHttpSingletonInstance().newCall(request).enqueue(callback);
    }
}
