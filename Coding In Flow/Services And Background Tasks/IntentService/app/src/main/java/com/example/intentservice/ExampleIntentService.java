package com.example.intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.intentservice.App.CHANNEL_ID;

public class ExampleIntentService extends IntentService {
    private static final String TAG = "ExampleIntentService";
    private PowerManager.WakeLock wakeLock;

    public ExampleIntentService() {
        super("ExampleIntentService");
        setIntentRedelivery(true);//ý định sẽ đc khởi tạo lại và mục đích cuối cùng sẽ đc chuyển giao
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "ExampleApp:Wakelock");
        wakeLock.acquire();
        Log.d(TAG, "Wakelock acquired");

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("ExampleIntentService")
                    .setContentText("Running")
                    .setSmallIcon(R.drawable.ic_android)
                    .build();

            startForeground(1, notification);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");
        String input = intent.getStringExtra("inputExtra");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, input +" - "+ i);
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        wakeLock.release();
        Log.d(TAG, "Wakelock released");
    }
}
