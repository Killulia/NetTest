package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class MatrixTestView extends View {

    private static final int IMAGE_WIDTH = (int) Utils.dp2px(300);

    private Bitmap bitmap;
    private Matrix mMatrix;

    private Paint mShadowPaint;
    private Matrix mShadowGradientMatrix;
    private LinearGradient mShadowGradientShader;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera camera = new Camera();

    public MatrixTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setColor(Color.RED);

        bitmap = Utils.getHeadImg(getResources(), IMAGE_WIDTH);
        mMatrix = new Matrix();
        mShadowPaint = new Paint();
        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowGradientShader = new LinearGradient(0, 0, 0.5f, 0,
                Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP);
        mShadowPaint.setShader(mShadowGradientShader);

        mShadowGradientMatrix = new Matrix();
        mShadowGradientMatrix.setScale(bitmap.getWidth(),1);
        mShadowGradientShader.setLocalMatrix(mShadowGradientMatrix);
        mShadowPaint.setAlpha((int) (0.9*255));


//        float[] src = {0, 0, bitmap.getWidth(), 0, bitmap.getWidth(), bitmap.getHeight(), 0, bitmap.getHeight()};
//        float[] dst = {0, 0, bitmap.getWidth(), 100, bitmap.getWidth(), bitmap.getHeight()-50, 0, bitmap.getHeight()};
        float[] src = {bitmap.getWidth()/2, 0, bitmap.getWidth()/2, bitmap.getHeight()};
        float[] dst = {bitmap.getWidth()/2, 30, bitmap.getWidth()/2, bitmap.getHeight()-30};
        mMatrix.setPolyToPoly(src, 0, dst, 0, 2);//改变点的位置


    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.concat(mMatrix);//将matrix应用到canvas，即将bitmap.getWidth(), 0；bitmap.getWidth(), bitmap.getHeight()两个点改为dst
        //新的点
        canvas.drawBitmap(bitmap, 0, 0, null);//这时候画的图片基于新的点位
        //绘制阴影
//        canvas.drawRect(0,0,bitmap.getWidth(),bitmap.getHeight(),mShadowPaint);//画的矩形基于新的点位，是一个不规则四边形
//        canvas.drawLine(bitmap.getWidth(),0,600,0,paint);//画的线基于新的点位

    }
}
