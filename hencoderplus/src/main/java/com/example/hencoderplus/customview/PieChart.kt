package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class PieChart(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rectF = RectF()
    private val angles = intArrayOf(60,100,120,80)
    private val colors = intArrayOf(Color.parseColor("#B68D2F"),Color.parseColor("#567EB6"),Color.parseColor("#5DB64A"),Color.parseColor("#CB0F83"))



    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        rectF.set(width / 2 - RADIUS,height / 2 - RADIUS,width / 2 + RADIUS,height / 2 + RADIUS)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var currentAngle = 0
        for (i in colors.indices) {
            paint.color = colors[i]
            if (i == PULLED_INDEX) {
                canvas!!.save()
                //用current + angels[i]/2 = 锐角来推算，得到的就是这个结果即cos(2π-(current+angels[i]/2)) = cos(current + angels[i]/2)
                //每个色块结果可能不一样，要通过三角函数具体计算然后得到化简公式
                canvas.translate(cos(Math.toRadians(currentAngle + angles[i] / 2.toDouble())).toFloat() *PULLED_LENGTH,
                        sin(Math.toRadians(currentAngle + angles[i] / 2.toDouble())).toFloat() * PULLED_LENGTH)
            }
            canvas!!.drawArc(rectF, currentAngle.toFloat(), angles[i].toFloat(), true, paint)
            if (i == PULLED_INDEX) {
                canvas.restore()
            }
            currentAngle += angles[i]
        }

    }

    companion object{
        val RADIUS = dp2px(150F)
        const val PULLED_INDEX = 3
        val PULLED_LENGTH: Float = dp2px(20f)
    }
}