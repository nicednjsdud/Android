package kr.co.datatimeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

/*
        다음과 같이 수정하시오.
            1) <예약시작> 없애고 대신 예약 시작 기능은 크로노미터를 클릭하면 동작하게 하시오
            2) <예약완료> 없애고 대신 화면하단의 연도(0000년)을 롱 클릭하면 동작하게 하시오.
            3) 캘린더 뷰 대신에 데이트 피커를 사용하여 날짜를 설정하시오.
            4) 크로노미터 클릭하기 전 라디오버튼, 데이트피커, 타임피커가 안보이게 설정하시오.
                -> 크로노미터 클릭하면 라디오 버튼이 나타나게 하시오.
                -> 화면 하단의 연도(0000년)를 롱클릭하면 라디오버튼, 데이트피커, 타임피커가 다시
                   사라지게 하시오
 */
public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    RadioButton rdoCal, rdoTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView tvYear, tvMon, tvDay;
    TextView tvHour, tvMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.won1);

        setTitle("시간 예약");


        // 크로노미터
        chronometer = findViewById(R.id.chronometer);

        // 라디오 버튼 2개
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);

        // 텍스트 뷰
        tvYear = findViewById(R.id.tvYear);
        tvMon = findViewById(R.id.tvMon);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMin = findViewById(R.id.tvMin);

        // 처음에는 2개 안보이게 설정
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        // 타이머 설정
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });


        // 예약완료 버튼 클릭하면 시간을 가져옴
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(datePicker.getYear()));
                tvMon.setText(Integer.toString(datePicker.getMonth() + 1));
                tvDay.setText(Integer.toString(datePicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                return true;
            }
        });


    }
}