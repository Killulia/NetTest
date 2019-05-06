package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class CaemeraView extends View {
    public CaemeraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private static final int IMAGE_WIDTH = (int) Utils.dp2px(150);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap image;
    Camera camera = new Camera();



    {
        image = Utils.getAvatar(getResources(), IMAGE_WIDTH);
        camera.rotateX(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth() / 2,getHeight() / 2);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(image,-IMAGE_WIDTH/2,-IMAGE_WIDTH/2,paint);

    }
}
