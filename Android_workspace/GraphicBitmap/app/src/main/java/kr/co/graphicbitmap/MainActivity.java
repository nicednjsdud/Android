package kr.co.graphicbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        // 상하 반전 변환 행렬
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        Bitmap mBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                                             bitmap.getHeight(), matrix, false);

        Bitmap mBitmap2 = Bitmap.createScaledBitmap(bitmap,100,100,false);
        canvas.drawBitmap(mBitmap,0,0,null);
        canvas.drawBitmap(mBitmap2,300,1300,null);

    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}