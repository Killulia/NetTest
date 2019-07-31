package com.example.hencoderplus.kotlin


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.hencoderplus.R

class CodeView : AppCompatTextView {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val t1: String = "FLASH"
    private val t2: String = "SONIC"
    private val t3: String = "FLAME"
    private val t4: String = "STORM"
    private val t5: String = "THUNDER"
    private var temp: Int = 0
    private var list: List<String> = listOf(t1, t2, t3, t4, t5)

    init {
        paint.color = resources.getColor(R.color.colorAccent)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 13F
        paint.strokeCap = Paint.Cap.ROUND

    }

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0F, 0F, width.toFloat(), height.toFloat(), paint)
    }

    fun updateCode() {
        var index: Int
        while (true) {
            index = (Math.random() * list.size).toInt()
            if (temp != index)
                break
        }
        temp = index
        val text: String = list[index]
        setText(text)
        postInvalidate()

    }
}
