package com.example.hencoderplus.kotlin

import android.widget.Toast
//object相当于单例对象
object Utils {
    @JvmStatic //这样写java代码可以用以前的方式直接调用这个，变成真正的静态函数，只能在
    fun toast(string: String){
        Toast.makeText(BaseApplication.getInstance(),string,Toast.LENGTH_SHORT).show()
    }

}