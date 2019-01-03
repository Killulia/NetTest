package com.bksx.customview.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.bksx.customview.Custom1Activity;

public class CanvasTestView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private  int heigth;
    private  int width;


    public CanvasTestView(Context context) {
        super(context);
    }

    public CanvasTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Custom1Activity activity = (Custom1Activity) context;
        Display display = activity.getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        heigth = display.getHeight();


        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("ccg", "width:" + width);
        //TODO tanslate表示坐标系的移动，rotate（degree,px,py）px py表示旋转中心向x及y方向偏移的距离，而不是指具体的点，这一点从
        //TODO rotate源码可以看出：先调用tanslate(px,py)，再rotate，再tanslate(-px,-py)
        //TODO scale同理源码即：先移动中心点再朝中心点方向缩小，或由中心点向外延伸放大
        canvas.translate(width / 2, heigth / 2);
            /*
            rotate
             */
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        paint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,paint);
//
//        canvas.rotate(180,200,0);               // 旋转180度 <-- 旋转中心向右偏移200个单位
//
//        paint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,paint);
//
//        canvas.rotate(180,100,0);               // 旋转180度 <-- 旋转中心向右偏移200个单位
//
//        paint.setColor(Color.RED);            // 绘制蓝色矩形
//        canvas.drawRect(rect,paint);

        canvas.drawCircle(0,0,400,paint);
        canvas.drawCircle(0,0,350,paint);

        for (int i = 0; i < 36; i++) {
            canvas.drawLine(0,350,0,400,paint);
            canvas.rotate(10);
        }
    }
}
