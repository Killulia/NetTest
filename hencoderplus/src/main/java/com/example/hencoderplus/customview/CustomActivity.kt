package com.example.hencoderplus.customview

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PointFEvaluator
import android.animation.PropertyValuesHolder
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.hencoderplus.R


class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_measure)

    }

    private fun evaluatorTest() {
        /*val pointView: PointView = findViewById(R.id.cv)
        val targetPointF = PointF(dp2px(300F), dp2px(200F))
        val animator: ObjectAnimator = ObjectAnimator.ofObject(pointView, "point", PointFEvaluator(), targetPointF)
        animator.startDelay = 2000
        animator.duration = 2000
        animator.start()*/

        val provinceView: ProvinceView = findViewById(R.id.cv)
        val animator: ObjectAnimator = ObjectAnimator.ofObject(provinceView, "province", ProvinceUtil.ProvinceEvaluator(), "澳门特别行政区")
        animator.startDelay = 2000
        animator.duration = 10000
        animator.interpolator = LinearInterpolator()
        animator.start()
    }



    private fun animatorTest() {
        val circle: CircleView = findViewById(R.id.cv)
//        val animator = ObjectAnimator.ofFloat(circle,"radius", dp2px(180F))
//        val animator = ObjectAnimator.ofFloat(circle,"translationY", dp2px(200F))
//        animator.startDelay = 2000
//        animator.duration = 2000
//        animator.start()

        val length = dp2px(200F)
        val keyframe1 = Keyframe.ofFloat(0F, 0F)
        val keyframe2 = Keyframe.ofFloat(0.1F, (0.4 * length).toFloat())
        val keyframe3 = Keyframe.ofFloat(0.9F, (0.6 * length).toFloat())
        val keyframe4 = Keyframe.ofFloat(1F, 1 * length)
        val valuesHolder = PropertyValuesHolder.ofKeyframe("translationY", keyframe1, keyframe2, keyframe3, keyframe4)
        val animator = ObjectAnimator.ofPropertyValuesHolder(circle,valuesHolder)
        animator.startDelay = 2000
        animator.duration = 2000
        animator.start()

    }

    private fun layoutInflaterTest() {
        val layoutInflater = LayoutInflater.from(this)
        val buttonLayout = layoutInflater.inflate(R.layout.layout_inflate, null)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main_layout)
        mainLayout.addView(buttonLayout)


    }
}
