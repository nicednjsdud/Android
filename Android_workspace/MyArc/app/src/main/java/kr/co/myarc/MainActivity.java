package kr.co.myarc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    private Paint mPaints, mFramePaint;
    private RectF mBigOval;
    private float mStart, mSweep;

    private static final float SWEEP_INC = 2;
    private static final float START_INC = 15;

    public MyView(Context context) {
        super(context);

        mPaints = new Paint();
        mPaints.setAntiAlias(true);
        mPaints.setStyle(Paint.Style.FILL); // 도형 내부 채움
        mPaints.setColor(0x88FF0000);

        mFramePaint = new Paint();
        mFramePaint.setAntiAlias(true);
        mFramePaint.setStyle(Paint.Style.STROKE);   // 도형 외곽선만 그림
        mFramePaint.setStrokeWidth(3);
        mFramePaint.setColor(Color.GREEN);

        mBigOval = new RectF(40, 10, 900, 1000);

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        canvas.drawRect(mBigOval, mFramePaint);
        canvas.drawArc(mBigOval, mStart, mSweep, false, mPaints);
        mSweep += SWEEP_INC;
        if (mSweep > 360) {
            mSweep -= 360;
            mStart += START_INC;
            if (mStart >= 360) {
                mStart -= 360;
            }
        }
        invalidate();
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}