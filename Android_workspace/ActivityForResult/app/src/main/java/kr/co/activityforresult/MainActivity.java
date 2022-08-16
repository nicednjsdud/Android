package kr.co.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit1,edit2,edit3;
    private static final int GET_RESULT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);

        button.setOnClickListener(new View.OnClickListener() {
            // 버튼이 클릭되면 숫자들을 인텐트에 넣어서 서브 엑티비티를 호출
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("number1",Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("number2",Integer.parseInt(edit2.getText().toString()));
                startActivityForResult(intent,GET_RESULT);
            }
        });


    }
    // 결과가 되돌아오면 에디트텍스트에 표시함.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_RESULT) {
            if (resultCode == RESULT_OK) {
                edit3.setText("" + data.getIntExtra("RESULT", 0));
            }
        }
    }

}