/*
    1. if
        if(A) ~ else if (B)
        if(A) ~ else if (B) ~ else
 */

val number1: Int = 40

if (number1 == 10) {
    println("10 입니다.")
} else if (number1 == 20) {
    println("20 입니다.")
} else {
    println("10, 20 둘다 아닙니다.") //
}

if (number1 == 10) println("10 입니다.")
else if (number1 == 30) println("30 입니다.")
else if (number1 == 50) println("50 입니다.")
else println("10, 30, 50 다 아닙니다.") //

val number2: Int = 10 + 20
val number3: Int = if (number2 > 30) 40 else 50
println(number3)    // 50

/*
    when(조건을 검사할 값) {
        case 1 -> 동작 1
        case 2 -> 동작 2
        else -> 동작3
    }
 */

val number4: Int = 7
when (number4) {
    5 -> {
        println("5 입니다.")
    }
    6 -> {
        println("6 입니다.")
    }
    else -> {
        println("그 외입니다.")
    }
}

when (number4) {
    5 -> println("5 입니다.")
    6 -> println("6 입니다.")
    else -> println("그 외입니다.") //
}

when(number4){
    in 1..10 -> println("number4 is on 1 ~ 10 ") //
    in 20..30 -> println("number4 is on 20 ~ 30")
    in 40..60 -> println("number4 is on 40 ~ 60")
}