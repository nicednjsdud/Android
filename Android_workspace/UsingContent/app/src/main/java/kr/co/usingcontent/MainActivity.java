package kr.co.usingcontent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Cursor cursor;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.picture);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

    }

    public void displayFirstImage(View view) {
        Toast.makeText(getApplicationContext(), "displayFirstImage()", Toast.LENGTH_SHORT).show();

        try {
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA
            };
            cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection, null, null, null);
            int size = cursor.getCount();
            if (size == 0) {
                Toast.makeText(getApplicationContext(), "장치에 이미지가 없습니다.", Toast.LENGTH_SHORT).show();
            } else {
                if (cursor.moveToFirst()) {
                    String imageLocation = cursor.getString(1);
                    Toast.makeText(getApplicationContext(), imageLocation, Toast.LENGTH_SHORT).show();
                    File imageFile = new File(imageLocation);
                    if (imageFile.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(imageLocation);
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displaySecondImage(View view) {
        Toast.makeText(getApplicationContext(), "displaySecondImage", Toast.LENGTH_SHORT).show();
        try {
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA,
                    MediaStore.Images.ImageColumns.MIME_TYPE
            };

            cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection,null,null,null,null);
            int size = cursor.getCount();
            if(size==0){
                Toast.makeText(getApplicationContext(),"장치에 이미지가 없음",Toast.LENGTH_SHORT).show();
            }
            else{
                if(cursor.moveToLast()){
                    String imageLocation = cursor.getString(1);
                    Toast.makeText(getApplicationContext(), imageLocation, Toast.LENGTH_SHORT).show();
                    File imageFile = new File(imageLocation);
                    if(imageFile.exists()){
                        Bitmap bitmap = BitmapFactory.decodeFile(imageLocation);
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}