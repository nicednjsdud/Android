/*
    1. 기본적인 함수 모양
    fun 함수명(매개면수) : 반환 자료형{
        // 실행할 코드 내용
    }
 */

fun printAge(age: Int) : Unit {
    println(age)
}

printAge(19)        // 19

/*
    2. 함수 선언 간단하게 하는 방법
    fun 함수명(변수명 : 타입, 변수명2: 타입) = 함수 내용
 */

fun simplePlusNumbers(firstNum: Int, SecondNum: Int) = firstNum + SecondNum
var result: Int = simplePlusNumbers(firstNum = 10, SecondNum = 50)
println(result)     // 60

/*
    5. 가변인자를 갖는 함수
    fun 함수명(vararg 변수명 : 타입) : 반환형 {
        함수내용
        함수내용
        ...
        return 반환값
    }
 */

fun varargMultipleNumber(vararg numbers:Int) : Unit{
    for(number in numbers){
        println(number) // 1,2,3,4,5,6,7
    }
}
varargMultipleNumber(1,2,3,4,5,6,7)














