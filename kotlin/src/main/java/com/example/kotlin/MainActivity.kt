package com.example.kotlin


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var tvTest:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var x = 5
        x += 3
        Toast.makeText(this,"sury",Toast.LENGTH_SHORT).show()
        tvTest = findViewById(R.id.tv_test)
        check(tvTest)
    }

    private fun test() {
        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is","was")},but now is $a"
//        println(s2)
        Log.d("ccg",s2)

    }

    fun check(view : View?){
        Log.d("ccg", view?.id.toString())
    }




}
