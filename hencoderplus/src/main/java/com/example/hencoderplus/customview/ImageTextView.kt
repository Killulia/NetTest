package com.example.hencoderplus.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class ImageTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textPaint:TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var staticLayout:StaticLayout
    private var bitmap:Bitmap?
    private var cutWidth:FloatArray
    var metrics = Paint.FontMetrics()
    private val text = "Please send this message to those people who mean something to you," +
            "to those who have touched your life in one way or another," +
            "to those who make you smile when you really need it," +
            "to those that make you see the brighter side of things when you are really down," +
            "to those who you want to let them know that you appreciate their friendship." +
            "And if you don’t, don’t worry,nothing bad will happen to you," +
            "you will just miss out on the opportunity to brighten someone’s day with this message." +
            "I address you with neither rancor nor bitterness in the fading twilight of life, " +
            "with but one purpose in mind: to serve my country. " +
            "The issues are global and so interlocked that to consider the problems of one sector, " +
            "oblivious to those of another, is but to court disaster for the whole." +
            "While Asia is commonly referred to as the Gateway to Europe, it is no less true that Europe is the Gateway to Asia, " +
            "and the broad influence of the one cannot fail to have its impact upon the other. " +
            "There are those who claim our strength is inadequate to protect on both fronts, that we cannot divide our effort. " +
            "I can think of no greater expression of defeatism. If a potential enemy can divide his strength on two fronts, " +
            "it is for us to counter his effort. The Communist threat is a global one. " +
            "Its successful advance in one sector threatens the destruction of every other sector. " +
            "You can not appease or otherwise surrender to communism in Asia without simultaneously undermining our efforts to halt its advance in Europe."


    init {
        textPaint.textSize = dp2px(17F)
        textPaint.style = Paint.Style.FILL
        paint.textSize = dp2px(20F)
        bitmap = getHeadImg(resources, dp2px(150F).toInt())
        cutWidth = FloatArray(1)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        staticLayout = StaticLayout(text,textPaint,width,Layout.Alignment.ALIGN_NORMAL, 1F, 0F,false)
//        staticLayout.draw(canvas)
        canvas?.drawBitmap(bitmap!!,width - IMAGE_WIDTH, IMAGE_PADDING,paint)
        //The number of chars that were measured.
//        val count = paint.breakText(text,true, width.toFloat(),cutWidth)
//        canvas?.drawText(text,0,count,0F, paint.fontSpacing,paint)
        val length = text.length
        var yOffset = paint.fontSpacing
        var usableWidth: Int
        run {
            var start = 0
            var count: Int
            while (start < length) {
                val textTop = yOffset + metrics.ascent
                val textBottom = yOffset + metrics.descent
                usableWidth = if (textTop > IMAGE_PADDING && textTop < IMAGE_PADDING + IMAGE_WIDTH ||
                        textBottom > IMAGE_PADDING && textBottom < IMAGE_PADDING + IMAGE_WIDTH) {
                    (width - IMAGE_WIDTH).toInt()
                } else {
                    width
                }
                count = paint.breakText(text, start, length, true, usableWidth.toFloat(), cutWidth)
                canvas!!.drawText(text, start, start + count, 0f, yOffset, paint)
                start += count
                yOffset += paint.fontSpacing
            }
        }
    }

    companion object{
        private val IMAGE_WIDTH = dp2px(150F)
        private val IMAGE_PADDING = dp2px(100F)
    }



}