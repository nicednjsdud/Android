package kr.co.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        button.setOnClickListiner(object : View.onClickListner){
//            override fun onClick(p0: View?){
//                // to do..
//            }
//        })
//
//        // 1. Kotiln 인터페이스가 아닌 자바 인터페이스여야 합니다.
//        // 2. 그인터페이스는 딱 하나의 메소드만 가져야한다.
//
//        button.setOnClickListner{
//            // to do..
//        }
    }
}