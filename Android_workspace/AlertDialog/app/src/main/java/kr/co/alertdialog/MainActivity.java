package kr.co.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {    // activitiy_main 에서 onClick 정의
        // 빌더 객체 생성
        AlertDialog.Builder alertDBuilder = new AlertDialog.Builder(this);
        // 대화상자의 메세지 부분 설정
        alertDBuilder.setMessage("결제하시겠습니까?");
        alertDBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"결재가 완료되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        alertDBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"결재가 취소되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDBuilder.create();
        alertDialog.show();
    }

}