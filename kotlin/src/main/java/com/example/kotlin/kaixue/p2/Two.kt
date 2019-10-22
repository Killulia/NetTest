package com.example.kotlin.kaixue.p2
/*
Kotlin 函数参数默认是 val 类型，所以参数前不需要写 val 关键字，Kotlin 里这样设计的原因是保证了参数不会被修改，
而 Java 的参数可修改（默认没 final 修饰）会增加出错的概率。
 */
class Two {

    companion object {
        val test = "object"
    }

    init {
        print("init")
    }

    fun one(a:Int){
        print(""+a)
    }

    fun two(){
        var b = Util.a
    }

    fun three(){
        val three = Two.test
    }

    fun four(){
        val four = topLevel
    }
}