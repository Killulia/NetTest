package com.example.framework.network;

import com.example.framework.basemodel.BaseModel;
import com.example.framework.bean.DataBean;
import com.example.framework.bean.NewsBean;
import com.example.framework.bean.ToutiaoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {


    @GET("toutiao/index")
    Observable<BaseModel<NewsBean>> getNewsList(@QueryMap Map<String, String> map);

}
