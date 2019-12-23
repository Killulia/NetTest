package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class MatrixView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap?
    private var mPolyMatrix: Matrix? = null // 测试setPolyToPoly用的Matrix

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        bitmap = getHeadImg(resources, WIDTH.toInt())
        mPolyMatrix = Matrix()
        val src = floatArrayOf((-(bitmap!!.width/2)).toFloat(), (-(bitmap!!.height/2)).toFloat(), bitmap!!.width/2.toFloat(), (-(bitmap!!.height/2)).toFloat(), bitmap!!.width/2.toFloat(), bitmap!!.height/2.toFloat(), (-(bitmap!!.width/2)).toFloat(),bitmap!!.height/2.toFloat())
        val dst = floatArrayOf((-(bitmap!!.width/2)).toFloat(), (-(bitmap!!.height/2)).toFloat(), bitmap!!.width/2.toFloat(), (-(bitmap!!.height/2)).toFloat(), bitmap!!.width/2.toFloat()+200, bitmap!!.height/2.toFloat(), (-(bitmap!!.width/2)).toFloat()-200,bitmap!!.height/2.toFloat())
        mPolyMatrix!!.postTranslate((width / 2).toFloat(), (height / 2).toFloat())
        mPolyMatrix!!.setPolyToPoly(src,0,dst,0,src.size / 2)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate((width / 2).toFloat(), (height / 2).toFloat())
//        canvas?.drawBitmap(bitmap!!,mPolyMatrix!!,paint)
//        canvas?.drawBitmap(bitmap!!,(-(bitmap!!.width/2)).toFloat(), (-(bitmap!!.height/2)).toFloat(),paint)
        canvas?.drawRect((-(bitmap!!.width/2)).toFloat(), (-(bitmap!!.height/2)).toFloat(),bitmap!!.width/2.toFloat(),bitmap!!.height/2.toFloat(),paint)
        canvas?.drawBitmap(bitmap!!,mPolyMatrix!!,paint)
    }

    companion object {
        val WIDTH = dp2px(200F)
    }
}