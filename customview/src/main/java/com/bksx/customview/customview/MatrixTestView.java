package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class MatrixTestView extends View {

    private static final int IMAGE_WIDTH = (int) Utils.dp2px(200);

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

        bitmap = Utils.getHeadImg(getResources(), IMAGE_WIDTH);
        mMatrix = new Matrix();
        float[] src = {0, 0, bitmap.getWidth(), 0, bitmap.getWidth(), bitmap.getHeight(), 0, bitmap.getHeight()};
        float[] dst = {0, 0, bitmap.getWidth(), 100, bitmap.getWidth(), bitmap.getHeight()-100, 0, bitmap.getHeight()};
        mMatrix.setPolyToPoly(src, 0, dst, 0, 4);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);

    }
}
