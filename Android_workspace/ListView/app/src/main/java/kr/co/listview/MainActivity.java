package kr.co.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 배열에 저장된 데이터
        String[] values = {"Apple", "Persimmon", "Pear", "Oriental Melon",
                "Banana", "Peach", "Pomegranate", "Grapes", "Jujube", "Mango",
                "Citron", "Watermelon", "Orange","Apple", "Persimmon", "Pear", "Oriental Melon",
                "Banana", "Peach", "Pomegranate", "Grapes", "Jujube", "Mango",
                "Citron", "Watermelon", "Orange"};
        // 어댑터 생성
        ArrayAdapter<String> adapter =         // 리스트뷰의 표준 레이아웃(하나의 텍스트 뷰 사용)
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,values);
                                                                                     // 배열
        // 리스트 뷰에 어댑터 설정
        setListAdapter(adapter);
    }

    // 리스트 뷰 항목을 클릭(이벤트 발생)하게 되면 호출됨
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

//        super.onListItemClick(l, v, position, id);
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this,item + " selected",Toast.LENGTH_SHORT).show();
    }
}