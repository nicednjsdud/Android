package kr.co.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] titles = {
            "한산:용의 출현", "비상선언 (2021)", "탑건:매버 (2020", "미니언즈2 (2020)", "헤어질 결심 (1999)",
            "뽀로로 극장판 드래곤캐슬 대모험 (2022)", "외계+인 1부 (1998)", "극장판 도라에몽 : 진구의 우조소전생 (2022)",
            "DC 리그 오브 슈퍼-펫 (2022)", "명탐정 코난: 할로윈의 신부 (2021)"
    };
    Integer[] images = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie6,
            R.drawable.movie2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adpter = new CustomList(MainActivity.this);
        listView = findViewById(R.id.list);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),titles[+position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList(Activity context) {
            super(context, R.layout.listitem, titles);
            this.context = context;
        }

        // 반환하는 뷰를 사용하여 항목을 표시함
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = rowView.findViewById(R.id.image);
            TextView title = rowView.findViewById(R.id.title);
            TextView rating = rowView.findViewById(R.id.rating);
            TextView genre = rowView.findViewById(R.id.genre);
            TextView year = rowView.findViewById(R.id.releaseYear);

            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("4.0" +position);
            genre.setText("Drama");
            year.setText(2000+position+"");

            return rowView;
        }
    }
}