package com.example.kotlin.apipdf

import com.example.kotlin.kaixue.Father
import java.io.File

var a = "a"
val b = "${a.replace("a", "b")},old is $a"
fun main() {

}

fun maxOf(a: Int, b: Int) = if (a > b) "big" else "small"

fun isClass(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

fun forIndex() {
    val list = listOf("A", "B", "C")
    for (index in list.indices) {
        println("item at $index is ${list[index]}")
    }

}

fun whenTest(obj: Any): String =
        when (obj) {
            1       -> "one"
            "hello" -> "hello"
            else    -> "other"
        }

fun range(x:Int){
    //两边都是闭区间
    if (x !in 1..10){
        println("out of range")
    }
    //1-10区间迭代
    for (i in 1..10) {
        println("$i in range")
    }

    //1-10区间 5为步长迭代
    for (i in 1..10 step 5) {
        println("$i in range")
    }

    //检查是否包含某元素
    val str = "test"
    val list = listOf("t","b")
    if ("t" in str && "t" in list){
        println("all in")
    }

}

fun dataClass(){
    val data = Data(1,"first")
    data.name = "two"
    println("id:${data.id},name:${data.name}")
    val files = File("Test").listFiles()
    print(files?.size)
}

fun defaultFunction(c:Int = 1,d:Int = 2):Int = c + d

fun listTest(){
    val sample = listOf(1,2,3,4,5)
    val one = sample.filter { a -> a > 2 }
    val two = sample.filter { it > 4 }
    for (i in one) {
        print("$i,")
    }
    for (i in two) {
        print("$i,")
    }

}
fun typeJudge(x:Any){
    when(x){
        is A -> print("A")
        is B -> print("B")
        else -> print("Other")
    }
}
class A{}
class B{}
data class Data(val id:Int,var name:String)

