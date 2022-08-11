package kr.co.explicitintentdata2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("메인 액티비티");

        final EditText edtNum1 = findViewById(R.id.edtNum1);
        final EditText edtNum2 = findViewById(R.id.edtNum2);
        final RadioGroup radioGroup = findViewById(R.id.rdoGroup);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {

            // 버튼 클릭하면 SecondActivity 시작함.
            @Override
            public void onClick(View view) {
                // 명시적 인텐트
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radAdd:
                        intent.putExtra("Calc","+");
                        break;
                    case R.id.radSub:
                        intent.putExtra("Calc","-");
                        break;
                    case R.id.radMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.radDiv:
                        intent.putExtra("Calc","/");
                        break;
                    default:
                }
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            int answer = data.getIntExtra("answer",0);
            Toast.makeText(getApplicationContext(),"결과 : "+answer,Toast.LENGTH_SHORT).show();
        }
    }
}