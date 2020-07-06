package com.example.bilibili;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.d("ccg", "jet-resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disConnectListener() {
        Log.d("ccg", "jet-pause");
    }
}
