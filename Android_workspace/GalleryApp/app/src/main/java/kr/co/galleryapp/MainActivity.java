package kr.co.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = findViewById(R.id.gallery);

        MyGalleryAdapter galleryAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);

    }

    private class MyGalleryAdapter extends BaseAdapter {
        Context context;

        Integer[] posterId = {
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30,
                R.drawable.mov31, R.drawable.mov32, R.drawable.mov33, R.drawable.mov34, R.drawable.mov35,
                R.drawable.mov36, R.drawable.mov37, R.drawable.mov38, R.drawable.mov39, R.drawable.mov40,
                R.drawable.mov41, R.drawable.mov42, R.drawable.mov43, R.drawable.mov44, R.drawable.mov45,
                R.drawable.mov46, R.drawable.mov47, R.drawable.mov48, R.drawable.mov49, R.drawable.mov50,
                R.drawable.mov51, R.drawable.mov52, R.drawable.mov53, R.drawable.mov54, R.drawable.mov55,
                R.drawable.mov56, R.drawable.mov57, R.drawable.mov58, R.drawable.mov59, R.drawable.mov60,
                R.drawable.mov61, R.drawable.mov62, R.drawable.mov63, R.drawable.mov64, R.drawable.mov65,
                R.drawable.mov66, R.drawable.mov67, R.drawable.mov68, R.drawable.mov69, R.drawable.mov70,
                R.drawable.mov71, R.drawable.mov72, R.drawable.mov73, R.drawable.mov74, R.drawable.mov75,
                R.drawable.mov76, R.drawable.mov77, R.drawable.mov78, R.drawable.mov79, R.drawable.mov80,
                R.drawable.mov81, R.drawable.mov82, R.drawable.mov83,
        };
        String[] posterTitle = {
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3", "탑건 : 매버릭4", "헤어질 결심5",
                "헌트 6", "카터 7", "프레이 8", "미니언즈 9", "토르: 러브 앤 썬더 10",
                "비상선언1", "한산: 용의 출현 2", "외계+인 1부3"
        };

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 가운데 꽉채우기
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterId[i]);

            final int pos = i;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterId[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    View toastView = View.inflate(getApplicationContext(),R.layout.toast,null);
                    TextView toastText = toastView.findViewById(R.id.textView);
                    toastText.setText(posterTitle[pos]);

                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });


            return imageView;
        }
    }
}