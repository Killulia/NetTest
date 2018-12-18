package com.bksx.mvptest.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bksx.mvptest.presenter.MainPresenter;
import com.bksx.mvptest.net.OkHttpUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainModelImpl implements MainModel {

    private MainPresenter presenter;

    public MainModelImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadImg(String url, final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
            OkHttpUtil.doAsycGet(url, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()){
                        byte[] bytes = response.body().bytes();
//                    File file = new File(path);
//                    if (!file.exists()){
//                        file.createNewFile();
//                    }
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(bytes);
                        fos.close();
//                    final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    if (bitmap != null) {
//                        presenter.showImg(bitmap);
//                    }

                    }
                }

            });
        }
        final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmap != null) {
            presenter.showImg(bitmap);
        }



    }
}
