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

    private static final int IMAGE_WIDTH = (int) Utils.dp2px(150);
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


//        Camera变换 坐标原点在中央
        canvas.translate(getWidth() / 2, getHeight() / 2);
        //最新理论
        //ps:以plan B 为例，不要去管camera的位置，首先canvas.translate(getWidth() / 2, getHeight() / 2)将canvas的原点移到
        //View中心，camera.rotateX(30)会产生一个变换矩阵， camera.applyToCanvas(canvas)将这个变换矩阵付给了
        //现在的canvas使之旋转，而旋转又是需要旋转中心的，旋转中心就是原点，现在原点在View中心,则将整个canvas
        //绕view中心做旋转变换，再在这个变换的canvas上画bitmap得到的就是想要的效果。plan A同理，二者实际效果相同
        camera.applyToCanvas(canvas);
        //canvas大小与view的大小一致或者说canvas无边界，最终的大小就是留在View范围内裁去多余的部分
        float w = canvas.getWidth();
        float h = canvas.getHeight();
        float vw = getWidth();
        float vh = getHeight();
        Log.d("ccg", "canvas大小：" + w + "," + h);
        Log.d("ccg", "view大小：" + vw + "," + vh);

        //plan A 这种是完成旋转后提前把原点移回去，所以画bitmap时为了让他在原来的位置，坐标用移回去的坐标系体系下的
//        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));
//        canvas.drawBitmap(bitmap, (getWidth() / 2)-(IMAGE_WIDTH / 2), (getHeight() / 2)-(IMAGE_WIDTH / 2), paint);
        //plan B 这种是完成旋转后在现在的坐标系下画bitmap,再把坐标系移回去
        canvas.drawBitmap(bitmap, -(IMAGE_WIDTH / 2), -(IMAGE_WIDTH / 2), paint);
        canvas.translate(-(getWidth() / 2), -(getHeight() / 2));




    }
}
