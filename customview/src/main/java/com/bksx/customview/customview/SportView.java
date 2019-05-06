package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class SportView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS = Utils.dp2px(150);
    private static final float RING_WIDTH = Utils.dp2px(20);
    private static final float PROGRESS_WIDTH = Utils.dp2px(18);
    Rect bounds = new Rect();
    Paint.FontMetrics metrics = new Paint.FontMetrics();
    public SportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setTextSize(Utils.dp2px(100));
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画环
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(RING_WIDTH);
        paint.setColor(Color.parseColor("#C4C4C4"));
        canvas.drawCircle(getWidth() / 2,getHeight() / 2 , RADIUS,paint);

        //画进度
        paint.setStrokeWidth(PROGRESS_WIDTH);
        paint.setColor(Color.parseColor("#CB0F83"));
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - RADIUS,getHeight()  / 2 - RADIUS, getWidth() / 2 +RADIUS,
                getHeight() / 2 + RADIUS,-90,225,false,paint);

        //画文字
        String text = "sury";
        paint.setStyle(Paint.Style.FILL);
//        paint.measureText(text);
//        paint.getTextBounds(text,0,text.length(),bounds);//适合静态文字居中
        paint.getFontMetrics(metrics);
        float offset = (metrics.descent + metrics.ascent) / 2f;//文字高度中心到当前基线（初始认为的正确显示位置）的距离，同时也是基线需要偏移的距离
        canvas.drawText(text,getWidth() / 2 ,getHeight()  / 2 - offset,paint);

        //画文字贴边
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(Utils.dp2px(150));
        paint.getTextBounds(text,0,text.length(),bounds);
        float small = bounds.top;
        canvas.drawText(text,-bounds.left,-bounds.top,paint);

        //另外一行小字
        paint.setTextSize(Utils.dp2px(15));
        paint.getTextBounds(text,0,text.length(),bounds);
        canvas.drawText(text,-bounds.left,-small + paint.getFontSpacing(),paint);
    }
}
