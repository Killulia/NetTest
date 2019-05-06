package com.example.kotlin

import android.net.Credentials
import android.net.wifi.hotspot2.pps.Credential
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var x = 5
        x += 3
        Log.d("ccg","asd")
        Toast.makeText(this,"sury",Toast.LENGTH_SHORT).show()
        test()
    }

    private fun test() {
        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is","was")},but now is $a"
//        println(s2)
        Log.d("ccg",s2)

    }



}
