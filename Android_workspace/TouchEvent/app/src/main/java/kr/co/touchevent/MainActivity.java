package kr.co.touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    // 커스텀 뷰 정의
    protected class MyView extends View {

        int x = 100, y = 100;
        String str;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(x, y, 100, paint);
            paint.setTextSize(50);
            canvas.drawText("액션의 종류 : " + str, 0, 100, paint);
        }

        // 뷰가 가진 재정의
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX();
            y = (int) event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN)
                str = "Action_Down";
            if (event.getAction() == MotionEvent.ACTION_UP)
                str = "Action_Up";
            if (event.getAction() == MotionEvent.ACTION_MOVE)
                str = "Action_Move";

            // 화면을 무효화하여서 화면을 다시 그리게 함
            invalidate();

            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView myView = new MyView(this);
        setContentView(myView);
    }
}