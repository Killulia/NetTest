package com.bksx.progress;

import android.os.Handler;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int setProgress = 0;
    ProgressBar progressBar;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setProgress += 10;
                progressBar.setProgress(setProgress);
                handler.postDelayed(this, 1000);
            }
        },1000);
    }

    private void initView() {
        progressBar = findViewById(R.id.pb);
    }
}
