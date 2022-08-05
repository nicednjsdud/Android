package kr.co.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.TextView);

        // 텍스트뷰에 컨텍스트 메뉴를 등록함
        registerForContextMenu(textView);


    }
    // 코드로 메뉴를 생성함
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("컨텍스트 메뉴");
        menu.add(0,1,0,"배경색: RED");
        menu.add(0,2,0,"배경색: GREEN");
        menu.add(0,3,0,"배경색: BLUE");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case 1:
                textView.setBackgroundColor(Color.RED);
                return true;
            case 2:
                textView.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                textView.setBackgroundColor(Color.BLUE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}