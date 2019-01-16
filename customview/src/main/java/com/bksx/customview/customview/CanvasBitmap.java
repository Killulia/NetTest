package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.R;

public class CanvasBitmap extends View {

    private Paint paint;
    private Bitmap bitmap;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jump);
    }

    public CanvasBitmap(Context context) {
        super(context);
    }

    public CanvasBitmap(Context context,  AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.jump).copy((Bitmap.Config.ARGB_8888), true);
        canvas.drawBitmap(bitmap,100,100,paint);
        Canvas canvas1 = new Canvas(bitmap1);
        canvas1.drawRect(100,100,150,150,paint);
        invalidate();
    }
}
