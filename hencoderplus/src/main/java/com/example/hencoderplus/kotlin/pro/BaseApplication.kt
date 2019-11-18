package com.example.hencoderplus.kotlin.pro

import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }

    companion object{
        @JvmStatic
        @get:JvmName("application")
        lateinit var currentApplication:Context
        private set   //防止外部修改
    }

}