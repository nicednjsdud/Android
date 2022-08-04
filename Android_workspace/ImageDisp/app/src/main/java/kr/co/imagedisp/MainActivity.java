package kr.co.imagedisp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View{
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        // 이미지 데이터를 포함하는 앱 리소스 객체 , 이미지 리소스 식별자
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.one);
        
        // 화면에 그려질 비트맵, 이미지가 그려질 위치
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
}