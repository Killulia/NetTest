package com.bksx.nettest.net;

import com.bksx.nettest.bean.NewsBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    //新闻
    @GET("{type}?")
    Observable<NewsBean> getNews(@Path("type")String type, @QueryMap Map<String, String> map);

    //图片下载
    @GET("timg?image&quality=80&size=b9999_10000&sec=1535519934469&di=7a952eee8b1d60b03177a8b3fc5cfd1f&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F171128%2F73-1G12QR142.jpg")
    Observable<ResponseBody> downloadImg();

}
