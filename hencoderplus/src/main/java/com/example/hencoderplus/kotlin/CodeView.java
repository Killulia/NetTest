package com.example.hencoderplus.kotlin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.hencoderplus.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeView extends AppCompatTextView {

    private Paint paint;
    public  final String T1 = "FLASH";
    public  final String T2 = "SONIC";
    private List<String> list = new ArrayList<>();


    public CodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);

        list.add(T1);
        list.add(T2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,getWidth(),getHeight(),paint);
    }

    private void updateCode(){
        int index = (int) (Math.random() * list.size());
        setText(list.get(index));
        postInvalidate();
    }
}
