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
val byteInt2: UByte = 100u
val shorInt2: UShort = 100u
val intergerInt: UInt = 100u
val longInt: ULong = 100u

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

val myAnswer: Boolean = true
val no: Boolean = false

/*
    5. 문자형
        - 한글자
 */

val text1: Char = 'A'
// val text2: Char = 'AA' // Err Char형은 문자가 반드시 하나만 들어가야 함.
// val text3: Char = "A"  // Err type mismatch

/*
    6. 문자열 형

 */

val text4: String = "안녕하세요."
// val text5: String = '안녕하세요.' // Err 문자열은 싱글포테이션 x
val text5: String = "안"

// 타입 추론
//val number1 = 10        // Int
//val number2 = 10.0     // Double

var number3 = 0x100    // 16진수 표기를 사용한 Int형으로 추론
val number4 = 200u     // UByte

// 큰 숫자 할당시 _로 자리수 구분할 수 있음.
val bigNumber: Long = 12_345_567_789_889

