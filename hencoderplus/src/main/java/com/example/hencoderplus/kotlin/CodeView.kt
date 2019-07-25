package com.example.hencoderplus.kotlin;


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView;
import com.example.hencoderplus.R

class CodeView : AppCompatTextView {

    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val t1: String = "FLASH"
    val t2: String = "SONIC"
    val t3: String = "FLAME"
    val t4: String = "STORM"
    val t5: String = "THUNDER"
    var temp: Int = 0
    var list: List<String> = listOf(t1, t2, t3, t4, t5)

    init {
        paint.color = getResources().getColor(R.color.colorAccent)
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

    fun upadateCode() {
        var index: Int
        while (true) {
            index = (Math.random() * list.size).toInt()
            if (temp != index)
                break
        }
        temp = index
        val text: String = list.get(index)
        setText(text)
        postInvalidate()
    }
}
