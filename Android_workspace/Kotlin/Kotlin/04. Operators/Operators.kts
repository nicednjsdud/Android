/*
    1. 산술 연산자

 */

val number1: Int = 1 + 10       // 11
val number2: Int = 2 - 10       // -8
val number3: Int = 2 * 40       // 80
val number4: Int = 40 / 2       // 20
val number5: Int = 45 % 7       // 3
println(number5)

/*
    2. 대입 연산자 , 복합 대입 연산자
 */

var number6: Int = 12
number6 += 8
number6 -= 10
number6 *= 2
number6 /= 5
println(number6)            // 4

/*
    3. 증감연산자 (++, --)
 */

var number7: Int = 10
println(number7++)          // 10
println(number7)            // 11
println(++number7)          // 12

/*
    4. 비교연산자
        1) == , !=
            - 값이 같은지 물어보는 연산자
        2) === , !==
            - 객체가 같은가?, 객체가 다른가?
            - 주소값이 같은지 물어보는 연산자.

 */

val number8: Int = 2
val number9: Int = 2
val result: Boolean = number8 > number9     // false
val result2: Boolean = number8 == number9   // true
println(result2)

/*
    5. 논리연산자
        1) Boolean을 대상으로만 연산 가능

 */

val boolean1: Boolean = false
val boolean2: Boolean = true
val result3: Boolean = boolean1 && boolean2 // false
val result4: Boolean = boolean1 || boolean2 // true

println(result4)