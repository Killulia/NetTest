package com.bksx.nettest.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.toutiaofanxingtest.DataBean;
import com.bksx.nettest.bean.toutiaofanxingtest.ToutiaoBean;
import com.bksx.nettest.effective.C2_1;
import com.bksx.nettest.net.ApiService;
import com.bksx.nettest.utils.Constants;
import com.bksx.nettest.utils.OkHttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetActivity extends AppCompatActivity {
    Retrofit retrofit;
    ApiService apiService;
    String RxZipString;

    private String[] permissions;

    //    retrofit2.Call<List<DataBean>> call;
    retrofit2.Call<ToutiaoBean> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        checkPermissions();

//        Log.d("ccg", url);
//        RequestBody requestBody = new FormBody.Builder()
//                .add("type","top")
//                .add("key","6ce2dfc57ad2abef3f6a51cf02cf9993")
//                .build();

        //表单okhttp请求  头条
        Map<String, String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "6ce2dfc57ad2abef3f6a51cf02cf9993");

        Map<String, String> idMap = new HashMap<>();//身份证接口参数
        idMap.put("key", "c5691e6fcdf9263b63c9a9117cc4d163");
        idMap.put("cardno", "211122199406193311");

        Map<String, String> pMap = new HashMap<>();//号码归属地接口参数
        pMap.put("phone", "13084151905");
        pMap.put("key", "9da23ccd3705f1b871838c378c977bc5");



//        OkHttpUtil.postKeyValueAsync(Constants.TEST_URL, map, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()){
//                    String result = response.body().string();
////                    Log.d("ccg", result);
//                    Gson gson = new Gson();
//                    NewsBean newsBean = gson.fromJson(result, NewsBean.class);
//                    Log.d("ccg", newsBean.getReason());
//                }
//            }
//        });

        //retrofit表单请求 头条
//        retrofit = new Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)
//                .client(OkHttpUtil.getOkHttpSingletonInstance())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();

        //retrofit表单请求 身份证和归属地
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ID_BASE_URL)
                .client(OkHttpUtil.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        apiService = retrofit.create(ApiService.class);


        //传统Retrofit请求
//        call = apiService.getNewsList(map);
//        call.enqueue(new retrofit2.Callback<ToutiaoBean>() {
//            @Override
//            public void onResponse(retrofit2.Call<ToutiaoBean> call, retrofit2.Response<ToutiaoBean> response) {
//                List<DataBean> list = response.body().getResult().getData();
//                for (DataBean bean : list) {
//                    Log.d("ccg", bean.getTitle());
//                }
//
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<ToutiaoBean> call, Throwable t) {
//                Log.d("ccg", "failuer；"+t.getMessage());
//            }
//        });

//        传统Rxjava请求
        Disposable disposable;// TODO 用Consumer的方式可以返回Disposable
        apiService.getPhoneInfo(pMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody dataBeanToutiaoBean) {
//                        Log.d("ccg", "ok"+dataBeanToutiaoBean.getResult().getData().get(0).getAuthor_name());
                        try {
                            Log.d("ccg", "ok"+dataBeanToutiaoBean.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ccg", "error" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //合并两个Observable
//        Observable observable1 = apiService.getPhoneInfo(pMap);
//        Observable observable2 = apiService.getIDInfo(idMap);
//        Observable.zip(observable1, observable2, new BiFunction<ResponseBody, ResponseBody,String>() {
//            @Override
//            public String apply(ResponseBody o, ResponseBody o2) throws Exception {
//                return o.string()+","+o2.string();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String o) throws Exception {
//                        RxZipString = o;
//                        Log.d("ccg", RxZipString);
//                    }
//                });




    }

    private void checkPermissions() {
        permissions = new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_SMS,
                Manifest.permission.INSTALL_SHORTCUT,
                Manifest.permission.MODIFY_AUDIO_SETTINGS

        };

        for (String permission : permissions) {
            int isGranted = ContextCompat.checkSelfPermission(this,permission);
            if (isGranted == PackageManager.PERMISSION_GRANTED){
                Log.d("ccg", permission+ "已授权");
            }else if (isGranted== PackageManager.PERMISSION_DENIED){
                Log.d("ccg", permission+ "未授权");
            }
        }
    }

}
