package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * TODO 可以自适应，圆心在View中间，且半径总为宽高最小值 2/3 的圆
 */
public class MeasureTest extends View {

    private float cx,cy,radius;

    private Paint paint;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
    }

    public MeasureTest(Context context) {
        super(context);
    }

    public MeasureTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, radius, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
        Log.d("ccg", "getMeasuredWidth():" + getMeasuredWidth());
        Log.d("ccg", "getMeasuredHeight():" + getMeasuredHeight());
        radius = Math.min(getMeasuredWidth() / 2,getMeasuredHeight() / 2) * 2 / 3 ;//TODO 取宽高最小值 2/3 做半径，防止超出View的范围
        Log.d("ccg", "radius:" + radius);

    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST://TODO View默认不支持AT_MOST，自己重写实现
                result = Math.min(300, specSize);//TODO 300为自己规定的最大值
                break;
        }

        cx = result / 2;//TODO 圆心横坐标
        Log.d("ccg", "resultW:" + result);


        return result;
    }

    private int measureWidth(int widthMeasureSpec) {

        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(300, specSize);
                break;
        }

        cy = result / 2;
        Log.d("ccg", "resultH:" + result);

        return result;
    }
}
