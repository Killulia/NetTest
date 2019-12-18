package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawLine(dp2px(30F), 100F, 200F, 200F,paint)
    }

    companion object{
        const val RADIUS = 400F
    }
}