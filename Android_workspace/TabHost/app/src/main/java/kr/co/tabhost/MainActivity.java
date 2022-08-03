package kr.co.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 탭호스트 변수 생성
        TabHost tabHost = getTabHost();

        // 텝스팩 생성
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("one");
        // 텝스팩을 탭과 연결
        tabSpec1.setContent(R.id.imageView1);
        // 탭을 탭호스트에 부착
        tabHost.addTab(tabSpec1);

        // 텝스팩 생성
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("two");
        // 텝스팩을 탭과 연결
        tabSpec2.setContent(R.id.imageView2);
        // 탭을 탭호스트에 부착
        tabHost.addTab(tabSpec2);

        tabHost.setCurrentTab(0);
    }
}