package com.bksx.nettest.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bksx.nettest.R;

import androidx.annotation.Nullable;

public class SwitchButton extends View {

    private Paint mPaint;
    private Bitmap bgImage,slideImage;
    private boolean switchState = false;
    private float currentX;
    private boolean isTouchable = false;

    public SwitchButton(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        int width = bgImage.getWidth();
        int height = bgImage.getHeight();
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制背景
        canvas.drawBitmap(bgImage,0,0,mPaint);
        //绘制滑块

        if (isTouchable ){
            float newLeft = currentX - slideImage.getWidth() / 2.0f;

            int maxLeft = bgImage.getWidth() - slideImage.getWidth();

            // 限定滑块范围
            if(newLeft < 0){
                newLeft = 0; // 左边范围
            }else if (newLeft > maxLeft) {
                newLeft = maxLeft; // 右边范围
            }
            canvas.drawBitmap(slideImage,newLeft,0,mPaint);
        }else {
            if (!switchState){
                canvas.drawBitmap(slideImage,0,0,mPaint);
            }else {
                int dis = bgImage.getWidth() - slideImage.getWidth();
                canvas.drawBitmap(slideImage,dis,0,mPaint);
            }
        }




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentX = event.getX();
                isTouchable = true;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = event.getX();
                isTouchable = true;
                break;
            case MotionEvent.ACTION_UP:
                isTouchable = false;
                currentX = event.getX();
                float center = bgImage.getWidth() / 2.0f;

                // 根据当前按下的位置, 和控件中心的位置进行比较.
                boolean state = currentX > center;
                switchState = state;
                break;

        }

        invalidate();
        return true;
    }

    public void setBgResorce(int bgResorce) {
        bgImage = BitmapFactory.decodeResource(getResources(), bgResorce);
    }

    public void setSlideResorce(int slideResorce) {
        slideImage = BitmapFactory.decodeResource(getResources(), slideResorce);
    }

    public void setSwitchState(boolean switchState) {
        this.switchState = switchState;
    }
}
