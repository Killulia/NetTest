package com.bksx.customview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.customview.Utils;

import androidx.annotation.Nullable;

public class ImageTestView extends View {
    private static final int IMAGE_WIDTH = (int) Utils.dp2px(150);
    private static final int IMAGE_PADDING = (int) Utils.dp2px(80);
    String text = "Please send this message to those people who mean something to you," +
            "to those who have touched your life in one way or another," +
            "to those who make you smile when you really need it," +
            "to those that make you see the brighter side of things when you are really down," +
            "to those who you want to let them know that you appreciate their friendship." +
            "And if you don’t, don’t worry,nothing bad will happen to you," +
            "you will just miss out on the opportunity to brighten someone’s day with this message." +
            "I address you with neither rancor nor bitterness in the fading twilight of life, " +
            "with but one purpose in mind: to serve my country. " +
            "The issues are global and so interlocked that to consider the problems of one sector, " +
            "oblivious to those of another, is but to court disaster for the whole." +
            "While Asia is commonly referred to as the Gateway to Europe, it is no less true that Europe is the Gateway to Asia, " +
            "and the broad influence of the one cannot fail to have its impact upon the other. " +
            "There are those who claim our strength is inadequate to protect on both fronts, that we cannot divide our effort. " +
            "I can think of no greater expression of defeatism. If a potential enemy can divide his strength on two fronts, " +
            "it is for us to counter his effort. The Communist threat is a global one. " +
            "Its successful advance in one sector threatens the destruction of every other sector. " +
            "You can not appease or otherwise surrender to communism in Asia without simultaneously undermining our efforts to halt its advance in Europe.";
    Bitmap bitmap;
    float[] measuredWidth = new float[1];
    Paint.FontMetrics metrics = new Paint.FontMetrics();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint textPaint = new TextPaint();
    public ImageTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        textPaint.setTextSize(Utils.dp2px(15));
        paint.setTextSize(Utils.dp2px(16));
        paint.getFontMetrics(metrics);
        bitmap = Utils.getHeadImg(getResources(), IMAGE_WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, getWidth() - IMAGE_WIDTH, IMAGE_PADDING, paint);

        int length = text.length();
        float yOffset = paint.getFontSpacing();
        int usableWidth;
        for (int start = 0, count; start < length; start += count, yOffset += paint.getFontSpacing()) {
            float textTop = yOffset + metrics.ascent;
            float textBottom = yOffset + metrics.descent;
            if (textTop > IMAGE_PADDING && textTop < IMAGE_PADDING + IMAGE_WIDTH ||
                    textBottom > IMAGE_PADDING && textBottom < IMAGE_PADDING + IMAGE_WIDTH) {
                usableWidth = getWidth() - IMAGE_WIDTH;
            } else {
                usableWidth = getWidth();
            }
            count = paint.breakText(text, start, length, true, usableWidth, measuredWidth);
            canvas.drawText(text, start, start + count, 0, yOffset, paint);
        }
    }
}
