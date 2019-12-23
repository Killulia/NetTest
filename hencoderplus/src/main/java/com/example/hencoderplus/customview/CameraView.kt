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
        camera.rotateX(30F)//camera的照射，即旋转中心为canvas坐标原点
        camera.setLocation(0F,0F,-4 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        canvas?.clipRect(0F,0F, OFFSET + WIDTH / 2, OFFSET + WIDTH / 2) 裁切



        //翻转的下半部分
        canvas?.save()
        canvas?.translate(OFFSET + WIDTH / 2,OFFSET + WIDTH / 2)//camera的照射旋转中心也随之移动到了中心
        camera.applyToCanvas(canvas)//先旋转坐标系，再画图得到的就是反转的，注意先旋转
        canvas?.clipRect(-WIDTH / 2, 0F,WIDTH / 2, WIDTH / 2)
        canvas?.drawBitmap(bitmap!!, -WIDTH / 2, -WIDTH / 2,paint)
        canvas?.translate(-(OFFSET + WIDTH / 2),-(OFFSET + WIDTH / 2))
        canvas?.restore()

        //不翻转的上半部分
        canvas?.save()
        canvas?.translate(OFFSET + WIDTH / 2,OFFSET + WIDTH / 2)
        canvas?.clipRect(-WIDTH / 2, -WIDTH / 2,WIDTH / 2, 0F)
        canvas?.drawBitmap(bitmap!!, -WIDTH / 2, -WIDTH / 2,paint)
//        canvas?.drawBitmap(bitmap!!, OFFSET, OFFSET,paint)
        canvas?.translate(-(OFFSET + WIDTH / 2),-(OFFSET + WIDTH / 2))
        canvas?.restore()


    }

    companion object {
        val WIDTH = dp2px(200F)
        val OFFSET = dp2px(100F)

    }
}