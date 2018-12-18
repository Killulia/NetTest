package com.bksx.mvptest.net;



import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    //图片下载
    @GET("timg?image&quality=80&size=b9999_10000&sec=1545038957446&di=bcc6efd94cd18ecebe9778b11fa697b7&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170710%2F3556bafc524f4cadbb4d0ddd9fc11067.png")
    Observable<ResponseBody> downloadImg();


}
