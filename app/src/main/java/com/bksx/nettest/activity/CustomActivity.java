package com.bksx.nettest.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.NewsBean;
import com.bksx.nettest.custom.SwitchButton;
import com.bksx.nettest.net.ApiService;
import com.bksx.nettest.utils.Constants;
import com.bksx.nettest.utils.OkHttp3Utils;
import com.bksx.nettest.utils.OkHttpUtil;

import java.io.IOException;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class CustomActivity extends AppCompatActivity {
    ApiService apiService;
    Observable<NewsBean> call;
    Retrofit retrofit;
    String haystack = "aaaaa";
    String needle = "bba";
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        result = leetTest(haystack, needle);
        Log.d("ccg", "result:" + result);
        Toast.makeText(this, "result:" + result, Toast.LENGTH_SHORT).show();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(OkHttp3Utils.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        HashMap<String, String> quearyMap = new HashMap<>();
        quearyMap.put("type", "top");
        quearyMap.put("key", "6ce2dfc57ad2abef3f6a51cf02cf9993");
        call = apiService.getNews("index", quearyMap);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        Log.d("JSON", newsBean.getResult().getData().get(0).getAuthor_name());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private int leetTest(String haystack, String needle) {
        if (haystack.contains(needle)) {

            return haystack.indexOf(needle);
        }
        return -1;
    }
}
