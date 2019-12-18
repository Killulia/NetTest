package com.example.hencoderplus.kotlin.pro

import android.view.View
import android.widget.Toast


//扩展函数，不改变原有的类为其增加函数,比如可以避免写各种XXUtils,都放在一个kt文件的top level
fun String.expand() = this.length + 1
//扩展属性
val String.size:Int
    get() = this.length
fun main(){
    val data = Data("1","data")
    val dataCopy = data.copy()
    println(data)
    println(dataCopy)
    println(data == dataCopy)
    println(data === dataCopy)

    //解构对象，通过data class内部自动实现的component方法,按照声明顺序，code是component1(),data是component2()
    val(code,name) = data
    println("解构对象code:$code,name:$name")

    expandTest()

//    inTest()

    val view = TheView()
    view.setOnclickListener { onClick() }
    // 调用
    test(10) { num1: Int, num2: Int ->  num1 + num2 }  // 结果为：18
    proFunction()


}


// lambda
fun test(a : Int , b : (num1 : Int , num2 : Int) -> Int) : Int{
    return a + b.invoke(3,5)
}



/*
内敛函数，代码会直接复制到调用处，可反编译验证，适合传入的参数为函数类型时使用
 */
inline fun inTest(){
    println("inline")
}

fun onClick() {
    println("click1")
    println("click2")
    println("click3")
}

fun whenTest(){
    val colorRes = when (2) {
        1 -> ""
        2 -> "ok"
        else -> ""
    }
}

fun forTest(){
    val list = arrayListOf(1,2,3,4)
    for (item in list) print(item)
    for (i in list.indices) {
        print(list[i])
    }
    for ((index, value) in list.withIndex()) {
        println("the element at $index is $value")
    }

    //repeat循环函数，0..99
    repeat(100) { println(it)}
}

fun lambdaTest(){
    val list = listOf(1,2,3,4)
    list.forEach { it + 1 }

}

fun companyObject(){
    val application = BaseApplication.currentApplication
    //无法赋值因为set 被private了
}

fun expandTest(){
    val str = "test"
    println(str.expand())
}



fun onItemClick(view: View, position:Int){
    println("view is $view,position is $position")
}

/*
高阶函数
 */
fun proFunction(){
    fun addNum(a:Int,b:Int,add:(Int) -> Unit){
        val result = a + b
        add(result)
    }

    addNum(1,2){
        print("a + b = $it")
    }

    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    var str:String = "ff".repeatFun(2)
    val twoParameters: (String, Int) -> String = repeatFun // OK
}





class TheView{
    inline fun setOnclickListener(listener: () -> Unit){
        listener()
        println("ccc")
    }


}
