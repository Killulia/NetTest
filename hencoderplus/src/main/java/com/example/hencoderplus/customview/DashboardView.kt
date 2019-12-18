package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class DashboardView (context: Context?, attrs: AttributeSet?) : View(context, attrs){


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var dash = Path()
    private var arcPath = Path()
    private var effect: PathDashPathEffect? = null
    private var pathMeasure: PathMeasure? = null

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        dash.addRect(0F, 0F, dp2px(2F), dp2px(10F),Path.Direction.CCW)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        arcPath.reset()
        arcPath.addArc(width / 2 - RADIUS , height / 2 - RADIUS , width / 2 + RADIUS , height / 2 + RADIUS, (90 + OPEN_ANGEL / 2), (360 - OPEN_ANGEL))
        pathMeasure = PathMeasure(arcPath,false)
        //advance 是两个相邻的 shape 段之间的间隔，不过注意，这个间隔是两个 shape 段的起点的间隔，而不是前一个的终点和后一个的起点的距离
        effect = PathDashPathEffect(dash, (pathMeasure!!.length - dp2px(2F))/ 20, 0F,PathDashPathEffect.Style.ROTATE)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画弧  因为PathDashPathEffect是直接以效果去画图形并不是在图形基础上加效果，所以要分着画两次
        canvas?.drawArc(width / 2 - RADIUS , height / 2 - RADIUS , width / 2 + RADIUS , height / 2 + RADIUS, (90 + OPEN_ANGEL / 2), (360 - OPEN_ANGEL),false,paint)

        //画刻度
        paint.pathEffect = effect
        canvas?.drawArc(width / 2 - RADIUS , height / 2 - RADIUS , width / 2 + RADIUS , height / 2 + RADIUS, (90 + OPEN_ANGEL / 2), (360 - OPEN_ANGEL),false,paint)
        paint.pathEffect = null

        //画指针
         val x = dp2px(50F)*cos(Math.toRadians((90-(OPEN_ANGEL / 2 + (360- OPEN_ANGEL)/20)).toDouble()))
         val y = dp2px(50F)*sin(Math.toRadians((90-(OPEN_ANGEL / 2 + (360- OPEN_ANGEL)/20)).toDouble()))
        canvas?.drawLine((width/2).toFloat(), (height/2).toFloat(), (width/2-x).toFloat(), (height/2+y).toFloat(),paint)
    }

    companion object{
         val RADIUS = dp2px(150F)
         const val OPEN_ANGEL = 120F

    }
}
