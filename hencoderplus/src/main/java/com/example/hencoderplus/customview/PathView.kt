package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View




class PathView (context: Context?, attrs: AttributeSet?) : View(context, attrs){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path1 = Path()
    private val path2 = Path()
    private val path3 = Path()
    private val path4 = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.translate((width / 2).toFloat(), (height/ 2).toFloat())
        path1.addCircle(0F, 0F, 200F, Path.Direction.CW)
        path2.addRect(0F, (-200).toFloat(), 200F, 200F, Path.Direction.CW)
        path3.addCircle(0F, (-100).toFloat(), 100F, Path.Direction.CW)
        path4.addCircle(0F, 100F, 100F, Path.Direction.CCW)
//
//
        path1.op(path2, Path.Op.DIFFERENCE)
        path1.op(path3, Path.Op.UNION)
        path1.op(path4, Path.Op.DIFFERENCE)

        canvas.drawPath(path1, paint)
    }
}
