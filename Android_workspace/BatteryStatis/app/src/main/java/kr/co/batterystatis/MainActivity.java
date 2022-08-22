package kr.co.batterystatis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 방송 수신자를 동적으로 등록함.
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_REMOVED);
        registerReceiver(receiver,filter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Toast.makeText(context, action, Toast.LENGTH_SHORT).show();
            textView.setText(action);

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int maxValue = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                int value = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int level = value * 100 / maxValue;
                textView.setText(action + "\n 현재 배터리 레벨= "+level);
            }else if(action.equals(Intent.ACTION_BATTERY_LOW)){
                textView.setText(action + "\n 현재 배터리 부족 ");
            } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
                textView.setText(action+"\n SD카드 장착");
            } else if(action.equals(Intent.ACTION_MEDIA_UNMOUNTED)){
                textView.setText(action+"\n SD카드 해제");
            }
        }
    };
}