package com.bksx.customview.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ValueAnimatorTest extends View {
    //TODO ValueAnimator只是对数值操作并不控制具体属性，需要自己根据需求情况赋值给对应的属性
    private Paint paint;
    private RectF rectF;
    private ValueAnimator valueAnimator;

    public ValueAnimatorTest(Context context) {
        super(context);
    }

    public ValueAnimatorTest(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initAnimation();
    }

    private void initAnimation() {
        valueAnimator = ValueAnimator.ofFloat(100, 720);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value  = (float) animation.getAnimatedValue();
                rectF.right = value;
                Log.d("ccg", "value:" + value);
                invalidate();
            }
        });
        valueAnimator.start();
    }

    {
        rectF = new RectF();
        rectF.left = 100;
        rectF.top = 100;
        rectF.bottom = 200;
        rectF.right = 100;

    }
    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setARGB(125,40,44,52);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("ccg", "draw");
        canvas.drawRect(rectF,paint);
    }
}
