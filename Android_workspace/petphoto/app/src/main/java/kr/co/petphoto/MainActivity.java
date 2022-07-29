package kr.co.petphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 전역 변수 선언 - 위젯에 대응할 위젯 변수 9개
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup;
    RadioButton rDog, rCat, rRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("애완동물 사진 보기 앱");

        // 위젯을 변수에 대입
        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.ChkAgree);
        text2 = findViewById(R.id.Text2);
        rGroup = findViewById(R.id.Rgroup1);
        rDog = findViewById(R.id.RdoDog);
        rCat = findViewById(R.id.RdoCat);
        rRabbit = findViewById(R.id.RdoRabbit);

        btnOK = findViewById(R.id.BtnOK);
        imgPet = findViewById(R.id.ImgPet);

        // 시작함 체크박스의 체크가 변경되면
        // 체크박스를 체크/언체크할 때 동작하는  리스너 정의
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 체크면 모두 보이도록 설정
                if (chkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 선택완료 버튼 클릭하면 동작하는 리스너 정의
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.cat2);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.dobee);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택해주세요.",Toast.LENGTH_SHORT);
                }
            }
        });

    }
}