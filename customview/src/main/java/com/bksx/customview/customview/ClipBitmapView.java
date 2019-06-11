package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class ClipBitmapView extends View {
    private static final int IMAGE_WIDTH = (int) Utils.dp2px(200);
    private static final int IMAGE_PADDING = (int) Utils.dp2px(80);

    Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera camera = new Camera();
    private Path path = new Path();
    private Matrix matrix;

    public ClipBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {

        bitmap = Utils.getHeadImg(getResources(), IMAGE_WIDTH);
        camera.rotateX(45);//正着
        camera.setLocation(0,0,Utils.getZFromCamera(-10,getResources()));
        matrix = new Matrix();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //思路：上下部分分离开，用clip裁剪，上部分不变，下部分沿x轴旋转45度


        //1.正着翻页
        //上半部分
//        canvas.save();
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//        canvas.clipRect(-(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), (IMAGE_WIDTH / 2), 0);
//        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
//        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));
//        canvas.restore();
//
//        //下半部分
//        canvas.save();
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//        camera.applyToCanvas(canvas);
//        canvas.clipRect(-(IMAGE_WIDTH / 2), 0, (IMAGE_WIDTH / 2), (IMAGE_WIDTH / 2));
//        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
//        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));
//        canvas.restore();





        //2.斜着翻页
        //左半部分
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(45);
        camera.applyToCanvas(canvas);
        canvas.clipRect(-(IMAGE_WIDTH / 2),-(IMAGE_WIDTH / 2),(IMAGE_WIDTH / 2),0);
        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));
        canvas.restore();

//        下半部分
//        canvas.save();
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//        camera.applyToCanvas(canvas);
//        canvas.clipRect(-(IMAGE_WIDTH / 2), 0, (IMAGE_WIDTH / 2), (IMAGE_WIDTH / 2));
//        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
//        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));
//        canvas.restore();









    }
}
