/*
    1. 변수 A와 B를 선언하고, 두 변수의 값이 같은 경우에는 true
    그렇지 않으면 false가 되는 변수 C를 선언하시오.
    단 , 변수 A와 B의 자료형은 자유이고 에러가 발생하면 안되다.
 */

val A: Int = 10
val B: Int = 10
val C: Boolean = if(A==B) true else false
println(C)

val A1: String = "다시 해가"
val B1: String = "뜨겁게 떳네여."
val C1: Boolean = if(A1==B1) true else false
println(C1)

/*
    4. 수강생이 시험에서 맞은 문제의 개수를 넣어주면
       시험 점수(정수)를 반환하는 함수를 만드시오.
       단, 시험문제는 총 20문제이고, 만점은 100점이다.
 */

