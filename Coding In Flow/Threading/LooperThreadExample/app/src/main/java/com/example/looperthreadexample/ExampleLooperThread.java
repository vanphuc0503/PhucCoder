package com.example.looperthreadexample;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExampleLooperThread extends Thread {
    private static final String TAG = "ExampleLooperThread";

    public Looper looper;
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();

        looper = Looper.myLooper();
        handler = new ExampleHandler();

        Looper.loop();

        /*for (int i = 0; i < 5; i++) {
            Log.d(TAG, "run: "+ i);
            SystemClock.sleep(1000);
        }*/

        Log.d(TAG, "End of run()");
    }
}
