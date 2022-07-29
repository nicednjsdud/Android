package kr.co.versionphoto;
/*
    수정하시오.
        1) '좋아하는 안드로이드 버전은요?'
        2) '시작함'을 스위치 위젯으로 변경하시오.
        3) '선택완료' 대신에, 라디오 버튼을 선택할 대마다 즉시 해당 이미지가 나오도록 변경하시오.
        4) 버튼 2개 끝부분에 추가하시오.
            - 종료 => 응용 프로그램이 종료
            - 처음으로 => 초기화되고 처음화면이 나오게 함
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Switch switchAgree;
    RadioGroup rGroup;
    RadioButton[] radioArray = new RadioButton[3];
    ImageView imgView;
    Button btnQuit, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("안드로이드 버전 사진 앱");

        // 위젯을 변수에 대입
        textView1 = findViewById(R.id.textView);
        switchAgree = findViewById(R.id.switchAgree);
        textView2 = findViewById(R.id.textViewCho);
        rGroup = findViewById(R.id.Rgroup1);
        radioArray[0] = findViewById(R.id.RdoQ);
        radioArray[1] = findViewById(R.id.RdoR);
        radioArray[2] = findViewById(R.id.RdoS);
        btnReturn = findViewById(R.id.BtnReturn);
        btnQuit = findViewById(R.id.BtnQuit);
        imgView = findViewById(R.id.ImgView);

        // 시작함 체크박스의 체크가 변경되면
        // 체크박스를 체크/언체크할 때 동작하는  리스너 정의
        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 체크면 모두 보이도록 설정
                if (switchAgree.isChecked() == true) {
                    textView2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnReturn.setVisibility(View.VISIBLE);
                    imgView.setVisibility(View.VISIBLE);
                } else {
                    textView2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnReturn.setVisibility(View.INVISIBLE);
                    imgView.setVisibility(View.INVISIBLE);

                }
            }
        });

        // 라디오 버튼 클릭하면 동작하는 리스너 정의 (이미지 뷰를 변경시킴)
        final int[] draw = {R.drawable.q10, R.drawable.r11, R.drawable.s12};

        for (int i = 0; i < radioArray.length; i++){
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgView.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼 클릭
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 처음으로 버튼 클릭
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setVisibility(View.VISIBLE);
                rGroup.setVisibility(View.VISIBLE);
                btnQuit.setVisibility(View.VISIBLE);
                btnReturn.setVisibility(View.VISIBLE);
                imgView.setVisibility(View.VISIBLE);

                rGroup.clearCheck();
                switchAgree.setChecked(false);
            }
        });
    }
}