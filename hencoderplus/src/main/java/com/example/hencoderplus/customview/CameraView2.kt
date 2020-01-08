package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CameraView2 (context: Context?, attrs: AttributeSet?) : View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap?
    private val camera = Camera()
    private var mPolyMatrix: Matrix? = null // 测试setPolyToPoly用的Matrix

    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F
        paint.color = Color.BLUE
        bitmap = getHeadImg(resources, WIDTH.toInt())
        camera.rotateX(30F)//camera的照射，即旋转中心为canvas坐标原点
        camera.setLocation(0F,0F,-8 * resources.displayMetrics.density)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()
        canvas?.translate(OFFSET+ WIDTH / 2,OFFSET+ WIDTH / 2)
        camera.applyToCanvas(canvas)
        canvas?.rotate(45F)
        canvas?.translate(-(OFFSET+ WIDTH / 2),-(OFFSET+ WIDTH / 2))
        canvas?.drawBitmap(bitmap!!, OFFSET+ WIDTH / 2, OFFSET+ WIDTH / 2,paint)
        canvas?.restore()


    }

    companion object {
        val WIDTH = dp2px(200F)
        val OFFSET = dp2px(100F)

    }
}