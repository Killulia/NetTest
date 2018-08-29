package com.bksx.nettest.activity;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.NewsBean;
import com.bksx.nettest.interfaces.DownloadListener;
import com.bksx.nettest.net.ApiService;
import com.bksx.nettest.utils.Constants;
import com.bksx.nettest.utils.OkHttp3Utils;
import com.squareup.picasso.Picasso;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DownloadImgActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img;
    Button btDownload;
    ProgressBar progressBar;
    File file;
    Context context = this;
    String imgPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/jordan.jpg";

    ApiService apiService;
    Observable<ResponseBody> call;
    Retrofit retrofit;
    DownloadListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_img);
        listener = new DownloadListener() {
            @Override
            public void onStart() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                });
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onProgress(final int currentLength) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("asd", "onprogress");
                        progressBar.setProgress(currentLength);
                    }
                });



            }

            @Override
            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("asd", "finish");
                        progressBar.setVisibility(View.GONE);
                        Picasso.with(context).load(file).into(img);
                    }
                });



            }

            @Override
            public void onFailure() {

            }
        };
        initNet();
        initView();

    }

    private void initNet() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.IMG_URL)
                .client(OkHttp3Utils.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        call = apiService.downloadImg();
    }

    private void initView() {
        img = findViewById(R.id.imageView);
        btDownload = findViewById(R.id.button);
        btDownload.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        showImg(listener);
    }

    private void showImg(final DownloadListener listener) {

//        RxPermissions permissions = new RxPermissions((AppCompatActivity) context);
//        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        if (aBoolean) {
//                            handleFile(listener);
//                        }else {
//                            Toast.makeText(context, "获取失败", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });

        handleFile(listener);


    }

    private void handleFile(final DownloadListener listener) {
        //获取内部存储状态
        String state = Environment.getExternalStorageState();
        //如果状态不是mounted，无法读写
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "无法读写  ", Toast.LENGTH_SHORT).show();
            return;
        }
        file = new File(imgPath);
        if (file.exists()) {
            //本地已有，直接显示
            Picasso.with(context).load(file).into(img);
        } else {
            Log.d("ccg", "file not exists");
            try {
                file.createNewFile();
                //本地没有，网络下载到本地
                call.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(final ResponseBody response) {
                                new Thread(){
                                    @Override
                                    public void run() {
                                        write2Disk(response, listener);
                                    }
                                }.start();

                            }

                            @Override
                            public void onError(Throwable e) {
                                listener.onFailure();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private void write2Disk(ResponseBody response, DownloadListener listener) {
        Log.d("ccg", "write os");
        listener.onStart();
        long currentLength = 0;
        OutputStream os = null;
        InputStream is = response.byteStream(); //获取下载输入流
        long totalLength = response.contentLength();
        try {
            Log.d("ccg", "try");

            os = new FileOutputStream(file);
            int len;
            byte[] buff = new byte[2];
            while ((len = is.read(buff)) != -1) {
                Log.d("ccg", "while");
                os.write(buff, 0, len);
//                os.flush();
                currentLength += len;
                Log.d("akb", "totalLength:" + totalLength);
                Log.d("akb", "currentLength:" + currentLength);
                int por;
                por = (int) (100 * currentLength / totalLength);
                Log.d("asd", "por:" + por);
                listener.onProgress((int) (100 * currentLength / totalLength));
                if (currentLength == totalLength) {
                    listener.onFinish(); //下载完成
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close(); //关闭输出流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close(); //关闭输入流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
