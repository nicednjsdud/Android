package kr.co.myapplication


data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)

// toString(), hashCode(), equals(), copy()

fun main(){
    val ticketA = Ticket("koreanAir","bob","2023-06-05",14)
}