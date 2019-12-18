package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class PieChart extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();
    private static final float RADIUS = Utils.dp2px(150);
    private static final int PULLED_INDEX = 3;
    private static final float PULLED_LENTH = Utils.dp2px(20);
    int[] colors = {
            Color.parseColor("#1ABDE6"),
            Color.parseColor("#2BD5D5"),
            Color.parseColor("#BB4474"),
            Color.parseColor("#875EA2"),
    };
    int[] angels = {60,100,120,80};


    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bounds.set(getWidth() / 2 - RADIUS,getHeight() / 2 -RADIUS,
                getWidth() / 2 + RADIUS,getHeight() / 2 +RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int currentAngle = 0;
        for (int i = 0; i < colors.length; i++) {
            paint.setColor(colors[i]);
            if (i == PULLED_INDEX){
                canvas.save();
                //用current + angels[i]/2 = 锐角来推算，得到的就是这个结果
                canvas.translate((float)Math.cos(Math.toRadians(currentAngle + angels[i]/2))*PULLED_LENTH,
                        (float)Math.sin(Math.toRadians(currentAngle + angels[i]/2))*PULLED_LENTH);
            }
            canvas.drawArc(bounds,currentAngle,angels[i],true,paint);
            if (i == PULLED_INDEX){
                canvas.restore();
            }
            currentAngle += angels[i];
        }


    }
}
