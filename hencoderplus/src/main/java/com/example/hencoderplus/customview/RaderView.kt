package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class RaderView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var polyPath: Path
    private var centerX: Int = 0
    private var centerY: Int = 0
    private val count = 6
    private val angle = (Math.PI * 2 / count).toFloat()
    private val radius = 50

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        polyPath = Path()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2
        centerY = h / 2
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawPolygon(canvas)
    }

    private fun drawPolygon(canvas: Canvas?) {

        for (j in 1 until count) {
            val curR: Float = radius * j.toFloat()
            polyPath.reset()
            for (i in 0 until count) {
                if (i == 0) {
                    polyPath.moveTo(centerX + curR, centerY.toFloat())
                } else {
                    val x = (centerX + curR * cos(angle * i.toDouble())).toFloat()
                    val y = (centerY + curR * sin(angle * i.toDouble())).toFloat()
                    polyPath.lineTo(x, y)
                }
            }
            polyPath.close()
            canvas?.drawPath(polyPath, paint)
        }
    }

}