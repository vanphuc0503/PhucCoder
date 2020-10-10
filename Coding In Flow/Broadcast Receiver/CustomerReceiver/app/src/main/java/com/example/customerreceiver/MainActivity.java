package com.example.customerreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /*ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    // TODO: 9/29/For BroadcastSender project*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* // TODO: 9/29/2020 - For BroadcastSender project
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(exampleBroadcastReceiver, filter);*/

    }

   /* // TODO: 9/29/2020 - For BroadcastSender project
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }*/

}