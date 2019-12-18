package com.example.kotlin.other

fun main(){
    test()
    2.iop(1)
    1.acceptTest(2)
}

val test = { println("test") }

val test2:(Int,Int) -> Int = {a,b -> a+b}

val test3 = {a:Int,b:Int -> a+b}

val test4 = fun(x : Int , y : Int) : Int = x + y

/*
接收者类型：即调用此函数对象的类型
 */
val iop = fun Int.( other : Int) : Int = this + other
fun Int.acceptTest(other:Int):Int{
    return 1+other
}