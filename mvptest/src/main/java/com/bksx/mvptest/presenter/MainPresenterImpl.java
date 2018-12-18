package com.bksx.mvptest.presenter;

import android.graphics.Bitmap;

import com.bksx.mvptest.view.interfaces.MainView;
import com.bksx.mvptest.model.MainModel;
import com.bksx.mvptest.model.MainModelImpl;

import java.io.IOException;

public class MainPresenterImpl implements MainPresenter {

    MainModel model;
    MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        model = new MainModelImpl(this);
    }

    @Override
    public void loadImg(String url,String path) throws IOException {
        model.loadImg(url,path);
    }

    @Override
    public void showImg(Bitmap bitmap) {
        view.showImg(bitmap);
    }
}
