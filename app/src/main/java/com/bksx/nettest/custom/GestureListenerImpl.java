package com.bksx.nettest.custom;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListenerImpl implements GestureDetector.OnGestureListener {
    //触摸屏幕时均会调用该方法
    @Override
    public boolean onDown(MotionEvent e) {
        Log.e("akb","---> 手势中的onDown方法");
        return false;
    }

    //手指在屏幕上按下,且未移动和松开时调用该方法
    @Override
    public void onShowPress(MotionEvent e) {
        Log.e("akb","---> 手势中的onShowPress方法");
    }

    //轻击屏幕时调用该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.e("akb","---> 手势中的onSingleTapUp方法");
        return false;
    }

    //手指在屏幕上滚动时会调用该方法
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.e("akb","---> 手势中的onScroll方法");
        return false;
    }

    //手指长按屏幕时均会调用该方法
    @Override
    public void onLongPress(MotionEvent e) {
        Log.e("akb","---> 手势中的onLongPress方法");
    }

    //手指在屏幕上拖动时会调用该方法
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.e("akb","---> 手势中的onFling方法");
        return false;
    }
}

