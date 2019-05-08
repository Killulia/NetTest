package com.bksx.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.bksx.customview.customview.CameraView;
import com.bksx.customview.customview.ImageTestView;
import com.bksx.customview.customview.MatrixTestView;
import com.bksx.customview.customview.MatrixView;
import com.bksx.customview.customview.SportView;

public class MainActivity extends AppCompatActivity {


      MatrixTestView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Paint.FontMetrics metrics;
    }

    private void initView() {
        testView = findViewById(R.id.cv_test);
    }
}
