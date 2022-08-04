package kr.co.graphicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawColor(Color.BLUE);
        // 둥근 사각형 그리는 메소드
        // RectF는 사각형 객체, rx와 ry는 사각형 모서리부분의 반지름임.
        canvas.drawRoundRect(new RectF(30, 50, 330, 500), 15, 15, paint);

        // 타원을 그리는 메소드
        // RecF에 안에 있는 타원을 그림
        canvas.drawOval(new RectF(450, 50, 750, 550), paint);

        // 원호를 그리는 메소드
        // RecF에 안쪽에 그려지는 원호임. startAngle에서 시작하여 sweepAngle까지 원호를 그림
        // 각도의 단위 도(degree)이며 시계방향으로 증가함. sweepAngle이 360도 보다 크면 타원이 전부 그려짐
        // useCenter가 true면 원점포함하여 원호모양으로 그려짐.
        paint.setColor(Color.RED);
        canvas.drawArc(new RectF(30, 600, 330, 1100), 360, 1000, true, paint);

        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        float[] pts = {30, 1250, 300, 1350, 300, 1350, 60, 1450, 60, 1450, 360, 1500};
        canvas.drawLines(pts,paint);
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