package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.bksx.customview.R;

public class PieView extends View {

    private Paint paint1,paint2,textPaint;
    private int width,height;
    private float startAngle,sweepAngle;
    private float radius;
    private String text;
    private Rect bounds;

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
        invalidate();
    }

    {
        //圆弧
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(getResources().getColor(R.color.colorAccent));
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeCap(Paint.Cap.ROUND);
        paint1.setStrokeWidth(20);

        //圆
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(getResources().getColor(R.color.colorAccent));
        paint2.setStyle(Paint.Style.FILL);

        //文字
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(20);
//        textPaint.setTextAlign(Paint.Align.CENTER);

        startAngle = -90;
        sweepAngle = 225;
        radius = 100;
        text = "自定义控件";
        bounds = new Rect();
    }

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
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

        width = result;
        return result;
    }

    private int measureHeight(int heightMeasureSpec) {

        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(300, specSize);
                break;
        }

        height = result;
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);
        canvas.drawArc(-200,-200,200,200,startAngle,sweepAngle,false,paint1);
        canvas.drawCircle(0,0,radius,paint2);
        //使文字居中
        float textWidth = textPaint.measureText(text);
        canvas.drawText(text,-(textWidth/2),0,textPaint);

    }
}
