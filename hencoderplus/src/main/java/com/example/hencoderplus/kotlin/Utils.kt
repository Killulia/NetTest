package com.example.hencoderplus.kotlin

import android.widget.Toast

object Utils {
    @JvmStatic //java可以用以前的方式直接调用，即静态函数，只能在
    fun toast(string: String){
        Toast.makeText(BaseApplication.getInstance(),string,Toast.LENGTH_SHORT).show()
    }

}