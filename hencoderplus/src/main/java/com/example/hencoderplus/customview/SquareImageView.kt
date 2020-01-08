package com.example.hencoderplus.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class SquareImageView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, (l+dp2px(200F)).toInt(), (t+ dp2px(200F)).toInt())
    }
}