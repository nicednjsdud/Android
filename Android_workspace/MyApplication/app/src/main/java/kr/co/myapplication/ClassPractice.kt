package kr.co.myapplication

open class Human (val name : String = "Anonyumous"){

    constructor(name: String,age: Int): this(name){
        println("my name is ${name}, ${age}years old")
    }

    init {
        println("New human has been born!!")
    }


    fun eatingCake(){
        println("This is YUMMYYYY~~~")
    }

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human(){
    override  fun singASong(){
        super.singASong()
        println("라라랄")
        println("my name is :${name}")
    }
}


fun main(){
//    val human = Human("BoB")
//    human.eatingCake()
//
//    val mom = Human("BoBMom",52);
//
//    println("this human's name is ${human.name}")
    val korean = Korean()
    korean.singASong()
}