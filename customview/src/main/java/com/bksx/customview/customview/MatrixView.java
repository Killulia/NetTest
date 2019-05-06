package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class MatrixView extends View {

    private static final int IMAGE_WIDTH = (int) Utils.dp2px(70);
    private static final int IMAGE_PADDING = (int) Utils.dp2px(80);

    Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera camera = new Camera();

    public MatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {

        bitmap = Utils.getHeadImg(getResources(), IMAGE_WIDTH);
        camera.rotateX(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //让在左上角的图片平移200后绕图片中心旋转45，效果应该是左上角出去屏幕外一点
        //1.反着写的情况，不考虑坐标系变化，想象是正序先平移200即canvas.translate(200,0)，
        //再绕图片中心旋转45即 canvas.rotate(45,200+IMAGE_WIDTH/2,IMAGE_WIDTH/2),然后把顺序调过来
        //得到如下代码
//        canvas.rotate(45,200+IMAGE_WIDTH/2,IMAGE_WIDTH/2);
//        canvas.translate(200,0);

        //2.正着顺序，考虑坐标系变化，先将坐标系右移200即canvas.translate(200,0)，让坐标系绕图片中心转
        //即canvas.rotate(45,IMAGE_WIDTH/2,IMAGE_WIDTH/2)，书写顺序不变得到如下代码
        //PS:就用第2种方法，不考虑第一种
//        canvas.translate(200,0);
//        canvas.rotate(45,IMAGE_WIDTH/2,IMAGE_WIDTH/2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);


//        Camera变换 坐标原点在中央
        canvas.translate(getWidth() , getHeight() / 2);
        camera.applyToCanvas(canvas);
        //canvas大小与view的大小一致或者说canvas无边界，最终的大小就是留在View范围内裁去多余的部分
        float w = canvas.getWidth();
        float h = canvas.getHeight();
        float vw = getWidth();
        float vh = getHeight();
        Log.d("ccg", "canvas大小："+w+","+h);
        Log.d("ccg", "view大小："+vw+","+vh);
        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
        canvas.translate(-getWidth() / 2, -getHeight() / 2);

        //Camera变换 坐标原点默认，即hencoder方式
        //ps:这种不对，因为canvas平移会带动camera的坐标系平移
//        canvas.translate(-(getWidth()/2),-(getHeight()/2));
//        camera.applyToCanvas(canvas);
//        canvas.drawBitmap(bitmap, getWidth()/2-IMAGE_WIDTH/2, getHeight()/2-IMAGE_WIDTH/2, paint);
//        canvas.translate(getWidth()/2,getHeight()/2);


    }
}
