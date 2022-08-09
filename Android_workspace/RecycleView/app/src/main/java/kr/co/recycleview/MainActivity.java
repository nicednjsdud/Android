package kr.co.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyRecycleViewAdapter.ItemClickListener {
    MyRecycleViewAdapter myRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = new String[1000];
        for (int i = 1; i <= 100; i++) {
            data[i - 1] = "bob #" + i;
        }
        // 배치관리자를 격자 배치 관리자로 함.
        RecyclerView recyclerView = findViewById(R.id.rview);
        int columns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        myRecycleViewAdapter = new MyRecycleViewAdapter(this, data);
        myRecycleViewAdapter.setClickListener(this);
        // 어댑터 연결
        recyclerView.setAdapter(myRecycleViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("리사이클러뷰", "item" + myRecycleViewAdapter.getItem(position));
    }
}