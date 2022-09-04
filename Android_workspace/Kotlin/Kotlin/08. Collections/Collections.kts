/*
    콜렉션 구분
     - 변경가능(크기) 여부
        - Mutable(변경가능)
        - Immutable (변경불가)
     - 특징에 따른 구분
        - List
            - Mutable , Immutable
        - Set
            - Mutable , Immutable
        - Map
            - Mutable , Immutable
     - 콜렉션은 전부다 크기가 고정되어 있지 않음.
 */

val numbers = listOf<Int>(1,2,3)
println(numbers)    // [1,2,3]
println(numbers[0]) // 1
// numbers[0] = 5   // error: no set method providing array access (수정 불가)
println(numbers.get(1))      //2
println(numbers.indexOf(3))  //2

/*
    2. List
    1) immutable
        - 형태
            - listOf<자료형>(값1,값2,값3)
    2) mutalbe
        - 형태
            0 mutableListOf<자료형>(값1,값2,값3)

 */

val numberMutableList = mutableListOf<Int>(1,2,3)
numberMutableList[0] = 100
println(numberMutableList)  // [100,2,3]

numberMutableList.add(50)
println(numberMutableList)  // [100,2,3,50]
numberMutableList.removeAt(1)
println(numberMutableList)  // [100,3,50]

numberMutableList.addAll(2, listOf<Int>(100,100))
println(numberMutableList) // [100, 3, 100, 100, 50]