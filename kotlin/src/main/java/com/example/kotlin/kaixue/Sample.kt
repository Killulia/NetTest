package com.example.kotlin.kaixue

import android.view.View


lateinit var view: View
var str: String? = "sdfsd"

fun cook(name: String?) {

}

fun main() {
    cook(str)
    str = "kimg"
    val father: Father = Sun()
    (father as? Sun )?.sun()

}


