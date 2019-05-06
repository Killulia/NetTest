package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.R;

public class CameraView extends View {
    private final int width;
    private final int height;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 100);
    Point point2 = new Point(600, 200);
    Matrix matrix = new Matrix();
    Camera camera = new Camera();

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jump);
        width = bitmap.getWidth() / 2;
        height = bitmap.getHeight() / 2;
    }


    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        camera.save();
//        matrix.reset();
//        camera.rotateX(30);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.preTranslate(-(200 + width), -(0 + height));
//        matrix.postTranslate(200 + width, 0 + height);
//
//        canvas.save();
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, 200, 0, paint);
//        canvas.restore();
/////////////////////////////////////////
        canvas.save();
        camera.save();
        camera.rotateX(-10);


        camera.applyToCanvas(canvas);
        camera.restore();

        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
    }


    //TODO 1.利用camera做平移，上方为y轴正方向,将camera的Matrix传给了canvas使得canvas的坐标系也发生了移动
    /*

        canvas.save();
        camera.save();
        camera.translate(0,200,0);


        camera.applyToCanvas(canvas);
        camera.restore();

        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

     */

    //TODO 2.matrix，下方为y轴正方向
    /*

        canvas.save();
        matrix.reset();

        matrix.postTranslate(0, 200);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

     */

    //TODO 3.sample12 第一部分分析
    /*
        camera.save();
        matrix.reset();              TODO 拿到一个初始单列矩阵
        camera.rotateX(30);
        camera.getMatrix(matrix);    TODO 计算当前状态下矩阵对应的状态，并将计算后的矩阵赋值给参数matrix，即-将x轴旋转30度后的结果放到matrix
        camera.restore();
        matrix.preTranslate(-center1X, -center1Y);
        matrix.postTranslate(center1X, center1Y); TODO 两次操作化matrix再变化
        canvas.save();
        canvas.concat(matrix);TODO 将matrix再传给canvas画出相应图形
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
     */
}
