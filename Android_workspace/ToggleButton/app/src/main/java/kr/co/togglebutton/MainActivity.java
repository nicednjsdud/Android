package kr.co.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }
    // 버튼 클릭되었을 때 수행되어야 하는 동작
    // 버튼이 토글되면 이미지 표시하거나 사라지게 함
    public void onToggleClicked(View view){
         boolean on = ((ToggleButton)view).isChecked();

         if(on){
             imageView.setImageResource(R.drawable.won1);
         }else{
            imageView.setImageResource(0);
         }
    }
}