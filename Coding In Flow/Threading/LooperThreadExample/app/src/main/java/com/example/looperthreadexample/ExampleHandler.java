package com.example.looperthreadexample;

import android.Manifest;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;

public class ExampleHandler extends Handler {
    private static final String TAG = "ExampleHandler";
    
    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what){
            case TASK_A:
                Log.d(TAG, "Task A execute");
                /*this.post(new Runnable() {
                    @Override
                    public void run() {

                                for (int i = 0; i < 5; i++) {
                                    Log.d(TAG, "run: "+i);
                                    SystemClock.sleep(1000);
                                }
                            }
                        });*/
                break;
            case TASK_B:
                Log.d(TAG, "Task B execute");
                break;
        }
    }
}
