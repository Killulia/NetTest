package com.example.artexploration.part1;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artexploration.R;

public class TransparentActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy2");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent2");
    }
}
