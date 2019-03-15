package com.bksx.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bksx.customview.R;

public class TopBar extends RelativeLayout {
    private String mLeftText,mRightText,mTittle;
    private Drawable mLeftTextBackground,mRightTextBackground;
    private int mLeftTextColor,mRightTextColor,mTittleTextColor;
    private float mTextSize;
    private Button mLeftButton,mRightButton;
    private TextView mTextView;
    private LayoutParams mLeftParams,mRightParams,mTittleParams;
    private topbarClickListener topbarClickListener;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftTextBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);
        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightTextBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = typedArray.getString(R.styleable.TopBar_rightText);
        mTextSize = typedArray.getDimension(R.styleable.TopBar_tittleTextSize, 10);
        mTittleTextColor = typedArray.getColor(R.styleable.TopBar_tittleTextColor, 0);
        mTittle = typedArray.getString(R.styleable.TopBar_tittle);
        typedArray.recycle();

        injectProperty(context);
    }

    private void injectProperty(Context context) {
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTextView = new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftTextBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightTextBackground);
        mRightButton.setText(mRightText);

        mTextView.setText(mTittle);
        mTextView.setTextColor(mTittleTextColor);
        mTextView.setTextSize(mTextSize);
        mTextView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton,mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton,mRightParams);

        mTittleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mTittleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTextView,mTittleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topbarClickListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topbarClickListener.rightClick();
            }
        });


    }

    public interface topbarClickListener{

        //左侧
        void leftClick();

        //右侧
        void rightClick();
    }

    public void setTopbarClickListener(TopBar.topbarClickListener topbarClickListener) {
        this.topbarClickListener = topbarClickListener;
    }

    public void setButtonVisible(int id,boolean flag){
        if (flag){
            if (id == 0){
                mLeftButton.setVisibility(VISIBLE);
            }else {
                mRightButton.setVisibility(VISIBLE);
            }
        }else {
            if (id == 0){
                mLeftButton.setVisibility(GONE);
            }else {
                mRightButton.setVisibility(GONE);
            }
        }
    }
}
