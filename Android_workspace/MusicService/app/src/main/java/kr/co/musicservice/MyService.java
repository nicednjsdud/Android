package kr.co.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = "MusicService";
    MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    // 서비스가 처음으로 실행되면 음악 재생기를 생성함.
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"onCreate()");

        mediaPlayer = MediaPlayer.create(this,R.raw.dbd);
        mediaPlayer.setLooping(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
        Toast.makeText(this,"MusicService가 중지되었습니다.",Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }
    // 서비스가 시작 될때마다 음악 재생 시작
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand()");
        Toast.makeText(this,"MusicService가 실행되었습니다.",Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
}