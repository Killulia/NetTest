package com.example.artexploration.part3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;




public class MyViewGroup extends RelativeLayout {

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("ccg", "dispatchTouchEvent/ViewGroup-"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d("ccg", "onInterceptTouchEvent-"+ev.getAction());
//        return true;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ccg", "onTouchEvent/ViewGroup-"+event.getAction());
        return true;
    }
}
