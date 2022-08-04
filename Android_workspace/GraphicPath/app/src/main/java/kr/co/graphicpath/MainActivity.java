package kr.co.graphicpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

class MyView extends View{
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Paint paint = new Paint();
        Path path = new Path();

        paint.setStyle(Paint.Style.STROKE);

        // 패스의 시작점 지정
        path.moveTo(20,400);

        // 패스에 직선을 추가함
        path.lineTo(300,800);

        paint.setColor(Color.BLUE);
        canvas.drawPath();
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}