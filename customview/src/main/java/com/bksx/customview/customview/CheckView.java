package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import com.bksx.customview.Custom1Activity;

public class CheckView extends View {

    private  int width,heigth;
    private Paint grayPaint,yellowPaint;
    private boolean isChecked;
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






    }
}
