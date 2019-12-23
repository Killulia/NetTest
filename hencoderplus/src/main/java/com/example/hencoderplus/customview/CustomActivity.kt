package com.example.hencoderplus.customview

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.hencoderplus.R

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

    }

    private fun animatorTest(){
        val circle:CircleView = findViewById(R.id.cv)
        val animator = ObjectAnimator.ofFloat(circle,"radius", dp2px(180F))
        animator.startDelay = 2000
        animator.start()
    }

    private fun layoutInflaterTest() {
        val layoutInflater = LayoutInflater.from(this)
        val buttonLayout = layoutInflater.inflate(R.layout.layout_inflate,null)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main_layout)
        mainLayout.addView(buttonLayout)


    }
}
