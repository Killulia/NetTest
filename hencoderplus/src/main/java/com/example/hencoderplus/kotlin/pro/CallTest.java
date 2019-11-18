package com.example.hencoderplus.kotlin.pro;

import android.app.Application;

public class CallTest {
    private Application application;
    public  void main(String[] args) {
        //1  什么都不加
//         application = (Application) BaseApplication.Companion.getCurrentApplication();
        //2  给currentApplication加JVM static注解变成真正的静态
//        application = (Application) BaseApplication.getCurrentApplication();
        //3  给currentApplication get方法加注解同时可以自定义名，使用kotlin的方式调用
        application = (Application) BaseApplication.application();

    }

}
