package com.example.framework.network;

import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {

    private static NetManager netManager;
    private OkHttpClient okHttpClient;
    private static ApiService apiService;
    private final int TIMEOUT = 10;

    private NetManager() {  //构造函数私有化，防止外部直接创建对象
        initOkhttp();
        initRetrofit();
    }
    // 只创建一次NetManager，对其构造函数私有化，在构造函数内部初始化okhttpclient 和 retrofit ,间接实现单例,使得只有一个Netmanager，
    // 同时只有一个okhttpclient 和 retrofit
    public static synchronized ApiService getApiService() {
        if (apiService == null) {
            netManager = new NetManager();
        }
        return apiService;
    }

    private void initOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)  //连接超时设置
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)  //写入缓存超时10s
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)  //读取缓存超时10s
                .retryOnConnectionFailure(true)  //失败重连
                .addInterceptor(new LoggingInterceptor());
//                .addInterceptor(new HeaderInterceptor())  //添加header
//                .addInterceptor(new NetCacheInterceptor());  //添加网络缓存

//        addLogIntercepter(builder);  //日志拦截器
//        setCacheFile(builder);  //网络缓存

        okHttpClient = builder.build();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetConstants.SERVER_ADDRESS)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    /**
     * 设置缓存文件路径
     */
//    private void setCacheFile(OkHttpClient.Builder builder) {
//        //设置缓存文件
//        File cacheFile = new File(DirConfig.HTTP_CACHE);
//        //缓存大小为10M
//        int cacheSize = 10 * 1024 * 1024;
//        Cache cache = new Cache(cacheFile,cacheSize);
//        builder.cache(cache);
//    }

    /**
     * 调试模式下加入日志拦截器
     * @param builder
     */
//    private void addLogIntercepter(OkHttpClient.Builder builder) {
//        if (AppConfig.isDebug) {
//            builder.addInterceptor(new LoggingInterceptor());
//        }
//    }

}
