package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.R

class HeadImage(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap
    private var transmode:PorterDuffXfermode
    private var bounds:RectF


    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F
        paint.color = Color.BLUE
        bitmap = getHeadImage(WIDTH.toInt())
        transmode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        bounds = RectF()
        bounds.set(OFFSET, OFFSET, OFFSET+ WIDTH, OFFSET+ WIDTH)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(300,200)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val saved = canvas?.saveLayer(bounds,paint)
        canvas?.drawCircle(dp2px(150F), dp2px(150F), dp2px(70F),paint)
        paint.xfermode = transmode
        canvas?.drawBitmap(bitmap, OFFSET, OFFSET,paint)
        paint.xfermode = null
        canvas?.restoreToCount(saved!!)

    }

    private fun getHeadImage(width:Int):Bitmap{
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.fultz)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,R.mipmap.fultz,options)
    }

    companion object {
        val WIDTH = dp2px(200F)
        val OFFSET = dp2px(50F)

    }

}



