package com.example.explicitbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
  /*      // TODO: 9/29/2020 BroadcastSender
       intent.setClass(this, ExampleBroadcastReceiver.class);*/
  /*      // TODO: 9/29/2020  Customer Receiver
        ComponentName cn = new ComponentName("com.example.customerreceiver",
                "com.example.customerreceiver.ExampleBroadcastReceiver");
        intent.setComponent(cn);*/
/*        // TODO: 10/3/2020 Cach 2
        intent.setClassName("com.example.customerreceiver",
                "com.example.customerreceiver.ExampleBroadcastReceiver");*/
       /* intent.setPackage("com.example.customerreceiver");*/

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(intent, 0);

        for (ResolveInfo info : infos){
            ComponentName cn = new ComponentName(info.activityInfo.packageName,
                    info.activityInfo.name);
            intent.setComponent(cn);
            sendBroadcast(intent);
        }

    }

}