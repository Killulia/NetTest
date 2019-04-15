package com.bksx.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bksx.customview.customview.TestView;

public class MainActivity extends AppCompatActivity {

    TestView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        testView = findViewById(R.id.cv_test);
    }
}
