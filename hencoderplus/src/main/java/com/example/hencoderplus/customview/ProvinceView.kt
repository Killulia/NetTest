package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ProvinceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var province:String = "北京市"
    set(value) {
        field = value
        invalidate()
    }

    init {
        paint.textSize = dp2px(50F)
        paint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText(province, (width / 2).toFloat(), (height/2).toFloat(),paint)
    }

}