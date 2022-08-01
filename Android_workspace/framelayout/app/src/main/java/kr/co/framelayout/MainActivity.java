package kr.co.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("프레임 레이아웃 앱");

        textView1=findViewById(R.id.view1);
        textView2=findViewById(R.id.view2);
        textView3= findViewById(R.id.view3);
    }
    public void onClick(View view){
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        switch (view.getId()){
            case R.id.button1:
                textView1.setVisibility(View.VISIBLE);
                break;
            case R.id.button2:
                textView2.setVisibility(View.VISIBLE);
                break;
            case R.id.button3:
                textView3.setVisibility(View.VISIBLE);
                break;
        }
    }

}