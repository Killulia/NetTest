package com.example.hencoderplus.temp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.example.hencoderplus.R;
import java.util.ArrayList;
import java.util.List;

public class CodeView extends AppCompatTextView {

    private Paint paint;
    private  final String T1 = "FLASH";
    private  final String T2 = "SONIC";
    private  final String T3 = "FLAME";
    private  final String T4 = "STORM";
    private  final String T5 = "THUNDER";
    private int temp = 0;
    private int index = 0;
    private List<String> list = new ArrayList<>();


    public CodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(13);
        paint.setStrokeCap(Paint.Cap.ROUND);

        list.add(T1);
        list.add(T2);
        list.add(T3);
        list.add(T4);
        list.add(T5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,getWidth(),getHeight(),paint);
    }

    public void updateCode(){
        int index;
        while (true){
            index = (int) (Math.random() * list.size());
            if (temp != index)
                break;
        }
        temp = index;
        String text = list.get(index);
        Log.d("tag", "text: "+text);
        setText(text);
        postInvalidate();
    }
}
