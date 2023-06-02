package kr.co.myapplication


// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다를 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

val square: (Int) -> (Int) = { number -> number * number }

val nameAge = { name: String, age: Int ->
    "my name is ${name} I'm ${age}"
}

fun main() {
    println(square(12))
    println(nameAge("BoB", 27))
    val a = "bob said"
    val b = "max said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendsString("bob",27))
    println(calculateGrade(97))
}

// 확장 함수

val pizzaIsGreat: String.() -> String = {
    this + "Pizza is the best!"
}

fun extendsString(name: String, age: Int): String {

    val introduceMyself: String.(Int) -> String = {
        "I'm ${this} and ${it} years old"
    }

    return name.introduceMyself(age)
}

// 람다의 return

val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표시하는 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2343)
}