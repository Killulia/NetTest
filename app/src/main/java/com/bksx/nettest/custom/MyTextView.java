package com.bksx.nettest.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MyTextView  extends GestureDetector.SimpleOnGestureListener{


    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("MyTextView", "双击");
        return super.onDoubleTap(e);
    }
}
