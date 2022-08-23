/*
    1. 변수를 자료형과 함께 선언하는 방법.
        val 변수명 : 타입 = value
        var 변수명 : 타입 = value
 */

var BobYes: Byte = 100

var Bob2022 = 100L
var number: Long = 100

val byteInt: Byte = 10
val shortInt: Short = 10
val longInt: Long = 10

// 양수만 표현
//val byteInt2: UByte = -100        // Err 음수가 들어감.
//val byteInt2: UByte = 10
//val shorInt2: UShort = 100
//val intergerInt: UInt = 100
//val longInt: ULong = 100

/*
    3. 실수형
 */

val floatNumber: Float = 10.0f // Float의 경우 할당하려는 값 뒤에 f를 붙여줘야 함.
val doubleNumber: Double = 10.0

// Err he integer literal does not conform to the expected type Double
// val doubleNumber2: Double = 10

// 타입 추론
val number1 = 10        // Int
val number2 = 10.0      // Double

/*
    4. 논리형
 */




