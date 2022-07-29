package kr.co.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv , btnRem;
    TextView textResult;
    String num1, num2;          // 입력될 2개 문자열을 저장할 변수
    Double result;              // 계산 결과를 저장할 실수 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("간단한 계산기");

        edit1 = findViewById(R.id.Edit1);   // 변수에 에디트 텍스트 위젯대입
        edit2 = findViewById(R.id.Edit2);

        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRem = findViewById(R.id.BtnRem);

        textResult = findViewById(R.id.TextResult);

        // 버튼을 클릭할 때 동작하는 클래스 정의
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    if(num2.trim().equals("0")){
                        Toast.makeText(getApplicationContext(),"0으로 나누면 안됩니다.",Toast.LENGTH_SHORT).show();
                    }else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        result = Math.floor((result*10)/10.0);       // 소수점 아래 1자리까지만 출력
                        textResult.setText("계산 결과 : " + result.toString());

                    }
                }
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    if(num2.trim().equals("0")){
                        Toast.makeText(getApplicationContext(),"0으로 나누면 안됩니다.",Toast.LENGTH_SHORT).show();
                    }
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : "+result.toString());
                }
            }
        });



    }
}