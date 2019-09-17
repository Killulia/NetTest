package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.R;
import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class HeadImgView extends View {

    Bitmap head;
    Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    RectF rectF = new RectF();
    RectF boeder = new RectF();
    Shader shader;


    public static final float WIDTH = Utils.dp2px(300);
    public static final float BODER_WIDTH = Utils.dp2px(10);
    public static final float PADDING = Utils.dp2px(20);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public HeadImgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setColor( Color.parseColor("#1ABDE6"));
        head = getHeadImg((int) WIDTH);
        shader = new BitmapShader(head, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);//另一种方法
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(PADDING,PADDING,PADDING+WIDTH,PADDING+WIDTH);
        boeder.set(PADDING-BODER_WIDTH,PADDING-BODER_WIDTH,PADDING+WIDTH+BODER_WIDTH,PADDING+WIDTH+BODER_WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(boeder,paint);
        int saved = canvas.saveLayer(rectF, paint);
        canvas.saveLayer(rectF,paint);
        canvas.drawOval(PADDING,PADDING,PADDING+WIDTH,PADDING+WIDTH,paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(head,PADDING,PADDING,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);
    }

    Bitmap getHeadImg(int width){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.fultz, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.fultz, options);
    }

}
