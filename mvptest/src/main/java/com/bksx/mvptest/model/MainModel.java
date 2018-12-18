package com.bksx.mvptest.model;

import android.graphics.Bitmap;

import java.io.IOException;

public interface MainModel {

    public void loadImg(String url, String path) throws IOException;
}
