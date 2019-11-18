package com.example.hencoderplus.kotlin.base

import android.content.Context
import android.util.AttributeSet
import android.view.View

class Dog {

    var id:Int? = 0
    var name:String? = ""

    constructor(name:String){
        this.name = name
    }

    constructor(id:Int){
        this.id = id
    }

}