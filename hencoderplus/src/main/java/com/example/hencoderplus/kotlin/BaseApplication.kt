package com.example.hencoderplus.kotlin

import android.app.Application
import android.content.Context

 class BaseApplication : Application() {

     override fun attachBaseContext(base: Context?) {
         super.attachBaseContext(base)
         application = this
     }

     companion object {
         private lateinit var application: Context


         fun getInstance():Context {

             return application
         }
     }
}
