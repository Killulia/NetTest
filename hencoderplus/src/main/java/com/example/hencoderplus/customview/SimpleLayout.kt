package com.example.hencoderplus.customview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class SimpleLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (childCount > 0){
            val childView = getChildAt(0)
            measureChild(childView,widthMeasureSpec,heightMeasureSpec)
        }

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (childCount > 0){
            val childView = getChildAt(0)
            //四个参数分别代表
            childView.layout(0,0,childView.measuredWidth,300)
        }
    }
}