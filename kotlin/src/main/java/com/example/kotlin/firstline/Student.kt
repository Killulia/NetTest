package com.example.kotlin.firstline
/*
子类构造方法必须调用父类构造方法，如果是主构造，则父类后边跟括号
 */
class Student(var sno:String,var grade:Int): Person(),Study {
    init {
        println("sno is $sno")
    }

    constructor(name:String):this("",0){}

    override fun readBooks() {
        TODO("Not yet implemented")
    }

//    override fun doHomework() {
//        TODO("Not yet implemented")
//    }
}


//class Student: Person {
//    constructor(name:String):super()
//
//
//}