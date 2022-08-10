package kr.co.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    int[] images = {R.drawable.image1,R.drawable.image2,R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(MainActivity.this,images);

        // 어댑터 연결
        viewPager.setAdapter(myPagerAdapter);
    }
}