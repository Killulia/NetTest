package com.example.hencoderplus.kotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hencoderplus.R

class LessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        Utils.toast("lesson")
        BaseApplication.getInstance()
    }
}
