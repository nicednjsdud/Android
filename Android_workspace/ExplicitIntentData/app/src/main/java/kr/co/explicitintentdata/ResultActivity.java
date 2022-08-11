package kr.co.explicitintentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
/*
        영화 투표앱 수정하시오.
            - 투표 결과 화면에서 가장 많은 표를 받은 그림과 그 제목을 화면에 보여주시오.
 */
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        // 앞 화면에서 보낸 투표 결과 값을 받음
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");
        Integer[] imageFiled = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,
                R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
        // 1등 그림이름과 그림 파일
        TextView textViewTop = findViewById(R.id.tvTop);
        ImageView imageViewTop = findViewById(R.id.ivTop);

        int max = 0;
        for(int i=0;i<voteResult.length;i++){
            if(voteResult[max]<voteResult[i]){
                max = i;
            }
        }
        textViewTop.setText(imageName[max]);
        imageViewTop.setImageResource(imageFiled[max]);

        // 9개의 TextView, RatingBar 객체 배열
        TextView[] tv = new TextView[imageName.length];
        RatingBar[] rbar = new RatingBar[imageName.length];

        // 9개의 TextView, RatingBar ID 배열
        Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for (int i = 0; i < imageName.length; i++) {
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }

        // 각 TextView, RatingBar에 넘겨 받은 값 반영
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}