package com.example.developers.api

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.example.developers.R
import com.example.developers.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var dataBinding:ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_test)
        animation()
    }

    private fun animation() {
        val hyperspaceJump: Animation = AnimationUtils.loadAnimation(this,R.anim.hyperspace_jump)
        dataBinding.view.startAnimation(hyperspaceJump)

    }

    private fun propertyAnimator() {
        val set: Animator? = AnimatorInflater.loadAnimator(this,R.animator.property_animator)
                .apply {
                    setTarget(dataBinding.view)
                    start()
                }

    }
}
