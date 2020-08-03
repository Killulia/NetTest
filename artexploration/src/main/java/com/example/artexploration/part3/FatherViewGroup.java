package com.example.artexploration.part3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class FatherViewGroup extends FrameLayout {

    public FatherViewGroup(Context context) {
        super(context);
    }
    public FatherViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xff9869B7);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction()!=2){
            Log.e("TAG", "FatherViewGroup-dispatchTouchEvent前:--" + ev.getAction());
        }

        boolean result =super.dispatchTouchEvent(ev);

        if (ev.getAction()!=2){
            Log.e("TAG", "FatherViewGroup-dispatchTouchEvent后:--" + ev.getAction()  + "result:"+result);
        }

        return result;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction()!=2){
            Log.e("TAG", "FatherViewGroup--onInterceptTouchEvent前:--" + ev.getAction() );
        }

        boolean result =super.onInterceptTouchEvent(ev);

        if (ev.getAction()!=2){
            Log.e("TAG", "FatherViewGroup--onInterceptTouchEvent后:--" + ev.getAction() + "result:"+result);
        }

        return result;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()!=2){
            Log.e("TAG", "FatherViewGroup-onTouchEvent前:--" + event.getAction());
        }

        boolean result =super.onTouchEvent(event);

        if (event.getAction()!=2){
            Log.e("TAG", "FatherViewGroup-onTouchEvent后:--" + event.getAction()  + "result:"+result);
        }

        return result;
    }
}

