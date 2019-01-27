package com.example.framework.network;

import com.example.framework.bean.DataBean;
import com.example.framework.bean.ToutiaoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {


    @GET("toutiao/index")
    Observable<ToutiaoBean<DataBean>> getNewsList(@QueryMap Map<String, String> map);

}
