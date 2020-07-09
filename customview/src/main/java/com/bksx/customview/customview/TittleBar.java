package com.bksx.customview.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bksx.customview.R;

public class TittleBar extends ConstraintLayout {

    private ImageButton ibBack;

    private TextView tvTittle;

    private Activity activity;

    private String tittle;

    private float titleSize;

    private int titleColor;

    private int backgroundColor;

    private View view;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public TittleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.activity = (Activity) context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TittleBar);
        this.tittle = typedArray.getString(R.styleable.TittleBar_title);
        this.titleSize = typedArray.getDimension(R.styleable.TittleBar_titleSize, 16);
        this.titleColor = typedArray.getColor(R.styleable.TittleBar_titleColor, Color.WHITE);
        this.backgroundColor = typedArray.getColor(R.styleable.TittleBar_backgroundColor, Color.WHITE);
        typedArray.recycle();
        initView(context);
    }

    private void initView(final Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.tittlebar_layout, this, true);
        view = rootView.findViewById(R.id.cl_root);
        tvTittle = findViewById(R.id.tv_tittle);
        tvTittle.setText(this.tittle);
        /*
        我们应该采用TypedValue.COMPLEX_UNIT_PX,也就是要用px作为单位来进行setTextSize ，
        即：textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,tsc_TextSize),否则会很大;
        给了默认值TypedValue.COMPLEX_UNIT_SP，而上面我们获取到的自定义属性的值，
        已经是给转换成px的值了，这里再按照sp为单位进行setTextSize ，肯定是要变大了
         */
        tvTittle.setTextSize(TypedValue.COMPLEX_UNIT_PX,this.titleSize);
        tvTittle.setTextColor(this.titleColor);
        view.setBackgroundColor(this.backgroundColor);
        ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        LayoutParams params = (LayoutParams) this.view.getLayoutParams();
        params.height = height;
        view.setLayoutParams(params);
    }
}
