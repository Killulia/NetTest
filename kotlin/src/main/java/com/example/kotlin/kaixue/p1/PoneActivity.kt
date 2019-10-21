package com.example.kotlin.kaixue.p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.kotlin.R

class PoneActivity : AppCompatActivity() {

    lateinit var tvTest:TextView
    var a = "haha"
    val b = 2
    var c:Int = 1
    var d: String? = null
    var array:IntArray = intArrayOf(1,2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pone)
        tvTest = findViewById(R.id.tv_test)
        three(a)
//        four(d)
        var user = User()
        user.name = "key"
        Log.d("ccg",user.name)
        six(tvTest)

    }

    fun one(){
        print("one")
    }

    fun two():String{

        return "two"
    }

    fun three(arg:String?){
        print(arg)
    }

    fun four(arg:String){
        print(arg)
    }

    fun five(obj: String?): Int? {
        return obj?.length
    }

    fun six(view: View?){
        print(view?.id)
    }
}
