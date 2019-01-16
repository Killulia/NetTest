package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MyTextView extends AppCompatTextView {

    private Paint paint1,paint2,mPaint;
    private int mViewWidth;
    private LinearGradient mLinearGradient;
    private Matrix matrix;
    private int translate;

    {
        //文字
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.BLUE);

        //背景
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setARGB(255,146,105,37);
        paint2.setStyle(Paint.Style.FILL);
    }

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth ==0 ){
            mViewWidth = getMeasuredWidth();
            if (mViewWidth>0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.BLUE, 0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint1);
//        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,paint2);
//        canvas.save();
//        canvas.translate(10,10);
        super.onDraw(canvas);
//        canvas.restore();
        if (matrix!=null){
            translate += mViewWidth / 5;
            if (translate>2*mViewWidth){
                translate = -mViewWidth;
            }
            matrix.setTranslate(translate,0);
            mLinearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);
        }
    }
}
