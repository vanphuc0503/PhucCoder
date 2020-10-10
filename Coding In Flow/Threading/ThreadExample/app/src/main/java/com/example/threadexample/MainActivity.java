package com.example.threadexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button buttonStartThread;

    private Handler mainHandler = new Handler();

    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartThread = findViewById(R.id.button_start_thread);
    }

    public void startThread(View view) {
        stopThread = false;

        /*// TODO: 10/4/2020 Thực hiện trên main thread không thể thao tác khi thread đang chạy
        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "startThread: "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        /*// TODO: 10/4/2020 Dùng extend Thread
        ExampleThread thread = new ExampleThread(10);
        thread.start();*/
        // TODO: 10/4/2020 Dung runnable
        ExampleRunnable runnable = new ExampleRunnable(10);
        new Thread(runnable).start();

        /*// TODO: 10/4/2020 Cach nhanh gon
        new Thread(new Runnable() {
            @Override
            public void run() {
                //work
            }
        }).start();*/
    }

    public void stopThread(View view) {
        stopThread = true;
    }

    class ExampleThread extends Thread {

        int seconds;

        ExampleThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ExampleRunnable implements Runnable{
        int seconds;

        public ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                if (stopThread){
                    return;
                }
                if (i == 5){
                    /*// TODO: 10/4/2020 Cach2
                    Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/
                    /*// TODO: 10/4/2020 Cach 1
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/

                    /*// TODO: 10/4/2020 Cach 3 (Nhanh)
                    buttonStartThread.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                }
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}