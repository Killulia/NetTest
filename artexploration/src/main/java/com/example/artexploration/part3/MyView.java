package com.example.artexploration.part3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyView extends AppCompatButton {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("ccg", "dispatchTouchEvent/View-"+event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ccg", "onTouchEvent/View:"+event.getAction());
        return false;
    }
}
