package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    private Paint mPaint;
    private Context mContext;// 上下文环境引用

    private int radiu;// 圆环半径

    public CircleView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


        mPaint.setStrokeWidth(10);

        mPaint.setStyle(Paint.Style.FILL);

        // 设置画笔颜色为自定义颜色
        mPaint.setColor(Color.argb(255, 255, 128, 103));
    }

    public CircleView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300,300,200,mPaint);
    }

//    @Override
//    public void run() {
//        /*
//         * 确保线程不断执行不断刷新界面
//         */
//        while (true) {
//            try {
//                /*
//                 * 如果半径小于200则自加否则大于200后重置半径值以实现往复
//                 */
//                if (radiu <= 200) {
//                    radiu += 10;
//
//                    // 刷新View
//                    postInvalidate();
//                } else {
//                    radiu = 0;
//                }
//
//                // 每执行一次暂停40毫秒
//                Thread.sleep(40);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }



}
