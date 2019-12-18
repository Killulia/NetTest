package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.abs


class SportView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bounds = Rect()
    private var metrics = Paint.FontMetrics()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画环
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = RING_WIDTH
        paint.color = Color.parseColor("#C4C4C4")
        canvas.drawCircle(width / 2.toFloat(), height / 2.toFloat(), RADIUS, paint)
        //画进度
        paint.strokeWidth = PROGRESS_WIDTH
        paint.color = Color.parseColor("#CB0F83")
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS,
                height / 2 + RADIUS, -90f, 225f, false, paint)
        //画文字
        val text = "sury"
        paint.style = Paint.Style.FILL
        //两种垂直居中方式:bounds,metrics即静态和动态
//        paint.getTextBounds(text,0,text.length,bounds)
//        val offset = (bounds.top + bounds.bottom) / 2
//        val top = bounds.top
//        val bottom = bounds.bottom
//        Log.d("ccg","top:$top,bottom:$bottom")
        // 文字baseline在y轴方向的位置
        paint.getFontMetrics(metrics)
        val offset = (metrics.ascent + metrics.descent) / 2
        canvas.drawText(text, (width/2).toFloat(), (height/2).toFloat()-offset,paint)

        //文字贴边
        paint.textAlign = Paint.Align.LEFT
        paint.textSize = dp2px(70f)
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(text, (-bounds.left).toFloat(), -bounds.top.toFloat(), paint)


    }

    companion object {
        private val RADIUS = dp2px(150f)
        private val RING_WIDTH = dp2px(20f)
        private val PROGRESS_WIDTH = dp2px(18f)
    }

    init {
        paint.textSize = dp2px(100f)
        paint.typeface = Typeface.MONOSPACE
        paint.textAlign = Paint.Align.CENTER
    }
}