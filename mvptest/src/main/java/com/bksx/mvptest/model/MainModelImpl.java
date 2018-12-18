package com.bksx.mvptest.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.SyncStateContract;

import com.bksx.mvptest.net.ApiService;
import com.bksx.mvptest.presenter.MainPresenter;
import com.bksx.mvptest.net.OkHttpUtil;
import com.bksx.mvptest.util.Constans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelImpl implements MainModel {

    private MainPresenter presenter;
    private ApiService retrofitInterface;

    public MainModelImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }

//    //传统okhttp
//    @Override
//    public void loadImg(String url, final String path) throws IOException {
//        final File file = new File(path);
//        if (!file.exists()){
//            file.createNewFile();
//            OkHttpUtil.doAsycGet(url, new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    if (response.isSuccessful()){
//                        byte[] bytes = response.body().bytes();
////                    File file = new File(path);
////                    if (!file.exists()){
////                        file.createNewFile();
////                    }
//                        FileOutputStream fos = new FileOutputStream(file);
//                        fos.write(bytes);
//                        fos.close();
////                    final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
////                    if (bitmap != null) {
////                        presenter.showImg(bitmap);
////                    }
//
//                    }
//                }
//
//            });
//        }
//        final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//        if (bitmap != null) {
//            presenter.showImg(bitmap);
//        }
//
//
//
//    }

    //RxJava+Retrofit
    @Override
    public void loadImg(String url, final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            initRetrofit();
            retrofitInterface.downloadImg()
                    .subscribeOn(Schedulers.io()) //TODO 优化使写文件也在IO,activity回调不写runonuithread
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ResponseBody>() {
                        @Override
                        public void accept(ResponseBody responseBody) throws Exception {
                            byte[] bytes = responseBody.bytes();
                            FileOutputStream fos = new FileOutputStream(file);
                            fos.write(bytes);
                            fos.close();
                        }
                    });

        }
        final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmap != null) {
            presenter.showImg(bitmap);
        }


    }

    //初始化Retrofit
    private void initRetrofit() {
        OkHttpClient client = OkHttpUtil.getOkHttpSingletonInstance();
        //Log.i(TAG, "---->initRetrofit: " + client.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.IMG_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                // Retrofit2+RxJava实现网络访问，必须设置以下选项。
                // RxJavaCallAdapterFactory就是把Call转换成Observable.
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitInterface = retrofit.create(ApiService.class);
    }
}
