package com.bksx.nettest.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.nettest.R;

public class CustomPoint extends View {

    Paint paint;
    int width;
    int height;

    public CustomPoint(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
    }

    public CustomPoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
    }

    public CustomPoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        if (width>height){
            width = height;
        }else {
            height = width;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100,100,paint);
    }
}
