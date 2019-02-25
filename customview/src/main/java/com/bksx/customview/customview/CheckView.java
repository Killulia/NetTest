package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.bksx.customview.Custom1Activity;

public class CheckView extends View {

    private  int width,heigth;
    private Paint grayPaint,yellowPaint,whitePaint;
    private boolean isChecked = true;
    //圆环进度计数器
    private int ringCounter = 0;
    private int circleConuter = 0;
    private float[] points = {-200,30,0,200,0,200,300,-200};


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public CheckView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        grayPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        grayPaint.setStyle(Paint.Style.STROKE);
        grayPaint.setStrokeWidth(20);
        grayPaint.setColor(Color.GRAY);
        grayPaint.setStrokeCap(Paint.Cap.ROUND);

        yellowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        yellowPaint.setStyle(Paint.Style.STROKE);
        yellowPaint.setStrokeWidth(20);
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setStrokeCap(Paint.Cap.ROUND);

       whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
       whitePaint.setStyle(Paint.Style.FILL);
//       whitePaint.setStrokeWidth(20);
       whitePaint.setColor(Color.WHITE);
       whitePaint.setStrokeCap(Paint.Cap.ROUND);

    }

    public CheckView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        Custom1Activity activity = (Custom1Activity) context;
        Display display = activity.getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        heigth = display.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2,heigth / 2);//将坐标系移动到屏幕中心
        if (!isChecked){
            canvas.drawArc(-400,-400,400,400,0,360,false, grayPaint);
            canvas.drawLines(points, grayPaint);
            return;
        }
        ringCounter += 12;
        if (ringCounter >= 360) {
            ringCounter = 360;

        }else {
            canvas.drawArc(-400,-400,400,400,90,ringCounter,false, yellowPaint);
        }

        if (ringCounter == 360){
            yellowPaint.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(width / 2,heigth / 2,200,yellowPaint);
            canvas.drawArc(-400,-400,400,400,90,ringCounter,true, yellowPaint);

            circleConuter+=4;

            if (200-circleConuter>=0){
                Log.d("ccg", "circle:"+circleConuter);
                canvas.drawCircle(0,0,200-circleConuter,whitePaint);//TODO 注意坐标系已经移到中心，圆心应是0,0
            }

        }


        postInvalidate();







    }
}