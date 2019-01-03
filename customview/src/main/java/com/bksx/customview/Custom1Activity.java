package com.bksx.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bksx.customview.customview.CameraView;
import com.bksx.customview.customview.CanvasTestView;
import com.bksx.customview.customview.CheckView;

public class Custom1Activity extends AppCompatActivity {

    private CheckView mCustomView;// 我们的自定义View




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom1);
        mCustomView = findViewById(R.id.cv_test);
//        new Thread(mCustomView).start();
    }
}
