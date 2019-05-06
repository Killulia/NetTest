package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.bksx.customview.Utils;
import androidx.annotation.Nullable;

public class TestView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path dash = new Path();
    Path arcPath;
    PathMeasure pathMeasure;
    PathDashPathEffect pathEffect;
    private static final float RADIUS = Utils.dp2px(100);
    private static final float ANGLE = 120;
    private static final float LENGTH = 100;
    private static final float SINGLE = (360-ANGLE)/20;
    private float A = (90 + ANGLE / 2) +(5 * SINGLE) - 90;


    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(3));
        dash.addRect(0,0,Utils.dp2px(2),Utils.dp2px(10),Path.Direction.CCW);
        arcPath = new Path();



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        path.addCircle(getWidth() / 2,getHeight() / 2,RADIUS,Path.Direction.CCW);
//        path.addRect(getWidth() / 2 - RADIUS  ,getHeight() / 2,getWidth() / 2 +RADIUS,
//                getHeight() / 2 + RADIUS * 2,Path.Direction.CW);
//        path.setFillType(Path.FillType.EVEN_ODD);
        arcPath.addArc(getWidth() / 2 - RADIUS,getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS,getHeight() /2+RADIUS,90 + ANGLE / 2,
                360 - ANGLE);
        pathMeasure = new PathMeasure(arcPath,false);
        pathEffect = new PathDashPathEffect(dash,  (pathMeasure.getLength()-Utils.dp2px(2))/20, 0, PathDashPathEffect.Style.ROTATE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPath(path,paint);
        //画外面的弧
        canvas.drawArc(getWidth() / 2 - RADIUS,getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS,getHeight() /2+RADIUS,90 + ANGLE / 2,
                360 - ANGLE,false, paint);

        paint.setPathEffect(pathEffect);
        //画刻度
        canvas.drawArc(getWidth() / 2 - RADIUS,getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS,getHeight() /2+RADIUS,90 + ANGLE / 2,
                360 - ANGLE,false, paint);
        paint.setPathEffect(null);

        //画指针
        canvas.drawLine(getWidth() / 2,getHeight()/2,
                getWidth()/2+(float)Math.cos(Math.toRadians(getAngle(5)))*LENGTH,
                getHeight()/2+(float)Math.sin(Math.toRadians(getAngle(5)))*LENGTH,paint);

    }

    float getAngle(int num){
        return (90 + ANGLE / 2) +SINGLE * num;
    }
}
