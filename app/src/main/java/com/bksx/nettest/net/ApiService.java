package com.bksx.nettest.net;

import com.bksx.nettest.bean.NewsBean;
import com.bksx.nettest.bean.toutiaofanxingtest.DataBean;
import com.bksx.nettest.bean.toutiaofanxingtest.ToutiaoBean;
import com.bksx.nettest.bean.mob.LoginResponse;
import com.bksx.nettest.bean.mob.RegisterResponse;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    //新闻
    @GET("{type}?")
    Observable<NewsBean> getNews(@Path("type")String type, @QueryMap Map<String, String> map);

    //新闻 TODO<ToutiaoBean<DataBean>>这样写是因为对返回的Response做了封装，对同一结构，内部某个类不同的Response用泛型做封装
    @GET("toutiao/index")
    Observable <ToutiaoBean<DataBean>>getNewsList(@QueryMap Map<String, String> map);


    //身份证
    @GET("idcard/index")
    Observable <ResponseBody>getIDInfo(@QueryMap Map<String, String> map);

    //归属地
    @GET("mobile/get")
    Observable <ResponseBody>getPhoneInfo(@QueryMap Map<String, String> map);

    //图片下载
    @GET("timg?image&quality=80&size=b9999_10000&sec=1535519934469&di=7a952eee8b1d60b03177a8b3fc5cfd1f&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F171128%2F73-1G12QR142.jpg")
    Observable<ResponseBody> downloadImg();


    //Mob用户注册
    @GET("user/rigister")
    Observable<RegisterResponse> regist(@Query("key")String key, @Query("username")String username, @Query("password")String password);

    //Mob用户登录
    @GET("user/login")
    Observable<LoginResponse> login(@Query("key")String key,@Query("username")String username,@Query("password")String password);

}
