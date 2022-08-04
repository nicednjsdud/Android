package kr.co.grapic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View{
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        // 선
        canvas.drawLine(100,100,700,100,paint);
        // 사각형
        canvas.drawRect(100,300,700,700,paint);
        // 원
        canvas.drawCircle(300,1200,200,paint);
        paint.setTextSize(80);
        // 텍스트
        canvas.drawText("Hello BOB!",100,900,paint);
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