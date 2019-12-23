package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView (context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var radius = dp2px(50F)
    set(value) {
        field = value
        invalidate()
    }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate((width/2).toFloat(), (height/2).toFloat())
        canvas?.drawCircle(0F, 0F,radius,paint)
    }
}