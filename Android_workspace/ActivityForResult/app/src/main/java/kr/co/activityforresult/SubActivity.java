package kr.co.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private EditText editText;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editText = findViewById(R.id.edit4);
        text = findViewById(R.id.text4);

        Button button_ok = findViewById(R.id.button2);

        Intent intent = getIntent();
        text.setText(""+intent.getIntExtra("number1",0)+" + "
            +intent.getIntExtra("number2",0)+" : ");

        // 버튼이 클릭되면 사용자가 입력한 숫자를 인텐트에 넣어서 메인액티비티에 전달함.
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("RESULT",Integer.parseInt(editText.getText().toString()));
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        Button button_cancel =  findViewById(R.id.button3);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

}