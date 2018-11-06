package com.bksx.customview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bksx.customview.customview.CircleView;

public class Custom1Activity extends AppCompatActivity {

    private CircleView mCustomView;// 我们的自定义View




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom1);
        mCustomView = findViewById(R.id.cv_circle);
//        new Thread(mCustomView).start();
    }
}
