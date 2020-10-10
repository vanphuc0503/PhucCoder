package com.example.gosync;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    OrderReceiver1 orderReceiver1 = new OrderReceiver1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        filter.setPriority(1);
        registerReceiver(orderReceiver1, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderReceiver1);
    }
}