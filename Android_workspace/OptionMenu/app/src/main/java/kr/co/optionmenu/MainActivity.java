package kr.co.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);  // 매뉴 리소스 팽창
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.blue:
                view.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.green:
                view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.red:
                view.setBackgroundColor(Color.RED);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
}