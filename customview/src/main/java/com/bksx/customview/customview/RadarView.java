package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class RadarView extends View {

    private int centerX;
    private int centerY;
    private Path polyPath;
    private int count = 6;
    private float angle = (float) (Math.PI * 2 / count);
    private Paint paint;
    private static final int RADIUS = 50;

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }
    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //中心坐标
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);



    }

    private void drawPolygon(Canvas canvas) {
        polyPath = new Path();
        for (int j = 1 ; j<count ; j++){
            float curR = RADIUS * j;
            polyPath.reset();
            for (int i = 0; i < count; i++) {
                if (i==0) {
                    polyPath.moveTo(centerX + curR,centerY);
                }else {
                    float x = (float) (centerX + curR * Math.cos(angle*i));
                    float y = (float) (centerY + curR * Math.sin(angle*i));
                    polyPath.lineTo(x,y);
                }
            }
            polyPath.close();
            canvas.drawPath(polyPath,paint);

        }
    }
}
