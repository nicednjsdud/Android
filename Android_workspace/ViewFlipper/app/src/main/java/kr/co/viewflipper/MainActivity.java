package kr.co.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("자동사진 보기 앱");

        Button btnStart,btnEnd;
        final ViewFlipper viewFlipper;

        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnStop);
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1000);  // 화면 넘김 간격 메소드

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면 넘김 시작
                viewFlipper.startFlipping();
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면 넘김 정지
                viewFlipper.stopFlipping();
            }
        });

    }
}