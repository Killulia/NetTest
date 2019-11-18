package com.example.hencoderplus.kotlin.base;


class User(name: String) {
    var id:Int? = null
    var name:String? = ""
    get() = field + "ddd"

    init {
        this.name = name
        println("init")
    }

    constructor(id:Int,name: String) : this(name){
        println("second constructor")
    }


//    constructor(name: String?) {
//        this.name = name
//    }
}