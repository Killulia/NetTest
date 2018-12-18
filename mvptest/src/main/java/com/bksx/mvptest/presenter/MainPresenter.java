package com.bksx.mvptest.presenter;

import android.graphics.Bitmap;

import java.io.IOException;

public interface MainPresenter {

    public void loadImg(String url,String path) throws IOException;

    public void showImg(Bitmap bitmap);

}
