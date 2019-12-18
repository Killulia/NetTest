package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class NuggetView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 17F
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRect(100F,100F,600F,300F,paint)
//        canvas?.save()
//        paint.color = Color.parseColor("#880FB5FD")
//        canvas?.rotate(45F,100F,100F)
//        canvas?.drawRect(100F,100F,600F,300F,paint)
//        canvas?.restore()
//        canvas?.save()
//        canvas?.scale(2F,2F,100F,100F)
//        paint.color = Color.parseColor("#88469F33")
//        canvas?.drawRect(100F,100F,600F,300F,paint)
//        canvas?.restore()
        //剪裁区域
        canvas?.clipRect(20, 100, 250, 300)
        canvas?.drawRect(0F, 0F, 200F, 300F, paint)




    }
}