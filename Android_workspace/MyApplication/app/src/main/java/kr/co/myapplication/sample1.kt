package kr.co.myapplication

import java.lang.IllegalArgumentException

fun main() {
//    helloWorld()
//    println(add(3, 2))
//    checkNum(1)
    // 3. String Template

//    val name2 = "BoB"
//    println("my name is ${name2}I'm 27")
//    forAndwhile()
//    nullCheck()
//    ignoreNulls("bob")
}

// 1. 함수

fun helloWorld() {
    println("Hello World!")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. val vs var
// val = value

fun hi() {

    val a: Int = 10

    var b: Int = 9

    b = 100

    val c = 100
    var d = 100
    var name = "BoB"
}

// 4. 조건식

fun maxBy(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxBy2(a: Int, b: Int) = if (a > b) a else b

fun checkNum(score: Int) {
    when (score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't konw")
    }

    var b = when (score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    when (score) {
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// Expression vs Statement

// 5. Array and List

// Array

// List 1. List 2. MutableList

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",11L)

    array[0] = 3
//    list[0] = 2 err

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
//    arrayList = arrayListOf() err

}

// 6. for / while

fun forAndwhile(){

    val students = arrayListOf("bob","james","jenny","hennifer")

    for( name in students){
        println("${name}")
    }

    var sum : Int = 0
    for(i in 1..10){
        sum += i
    }
    println(sum)

    var index = 0
    while(index < 10){
        index ++
        println("current index : ${index}")
    }

    for((index,name) in students.withIndex()){
        println("${index+1}번째 학생 " + name)
    }
}

// 7. Nullable / NonNull

fun nullCheck(){
    // NPE : Null Pointer Exception

    var name2 : String = "BoB"
    var nullName : String? = null

    var nameInUpperCase = name2.toUpperCase()

    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?:

    val lastName : String? = null
    val fullName = name2 +" " +  (lastName?: "NO lastName")
    var mLastName = lastName?: throw IllegalArgumentException("No last name")
    println(fullName)


    // !!

}

fun ignoreNulls(str : String?){
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()

    val email : String? = "bob.gmail.com"
    email?.let{
        
    }
}