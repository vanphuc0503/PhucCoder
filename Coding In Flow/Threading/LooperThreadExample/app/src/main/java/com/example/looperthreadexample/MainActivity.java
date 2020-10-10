package com.example.looperthreadexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import static com.example.looperthreadexample.ExampleHandler.TASK_A;
import static com.example.looperthreadexample.ExampleHandler.TASK_B;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    static ExampleLooperThread looperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view) {
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.looper.quit();
    }

    public void taskA(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);

        /*looperThread.handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "run: "+i);
                    SystemClock.sleep(1000);
                }
            }
        });*/
    }

    public void taskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);
    }
}