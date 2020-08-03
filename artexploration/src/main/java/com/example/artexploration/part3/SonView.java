package com.example.artexploration.part3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SonView extends View {
    public SonView(Context context) {
        super(context);
    }
    public SonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xffE58F46);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction()!=2){
            Log.e("TAG", "SonView-dispatchTouchEvent前:--" + event.getAction());
        }

        boolean result =super.dispatchTouchEvent(event);

        if (event.getAction()!=2){
            Log.e("TAG", "SonView-dispatchTouchEvent后:--" + event.getAction()  + "result:"+result);
        }

        return result;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()!=2){
            Log.e("TAG", "SonView-onTouchEvent前:--" + event.getAction());
        }

        boolean result =super.onTouchEvent(event);

        if (event.getAction()!=2){
            Log.e("TAG", "SonView-onTouchEvent后:--" + event.getAction()  + "result:"+result);
        }

        return result;
    }
}

