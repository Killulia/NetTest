package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CameraView (context: Context?, attrs: AttributeSet?) : View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap?
    private val camera = Camera()

    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F
        paint.color = Color.BLUE
        bitmap = getHeadImg(resources, WIDTH.toInt())
        camera.rotate(30F,0F,0F)
        camera.setLocation(0F,0F,-4 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        canvas?.clipRect(0F,0F, OFFSET + WIDTH / 2, OFFSET + WIDTH / 2) 裁切

        //不翻转的上半部分
        canvas?.save()
        canvas?.translate(OFFSET + WIDTH / 2,OFFSET + WIDTH / 2)
        canvas?.clipRect(-WIDTH / 2, -WIDTH / 2,WIDTH / 2, 0F)
        canvas?.translate(-(OFFSET + WIDTH / 2),-(OFFSET + WIDTH / 2))
        canvas?.drawBitmap(bitmap!!, OFFSET, OFFSET,paint)
        canvas?.restore()

        //翻转的下半部分
        canvas?.save()
        canvas?.translate(OFFSET + WIDTH / 2,OFFSET + WIDTH / 2)
        camera.applyToCanvas(canvas)
        canvas?.clipRect(-WIDTH / 2, 0F,WIDTH / 2, WIDTH / 2)
        canvas?.translate(-(OFFSET + WIDTH / 2),-(OFFSET + WIDTH / 2))
        canvas?.drawBitmap(bitmap!!, OFFSET, OFFSET,paint)
        canvas?.restore()


    }

    companion object {
        val WIDTH = dp2px(200F)
        val OFFSET = dp2px(100F)

    }
}