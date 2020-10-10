package com.example.customerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
/*        // TODO: 9/29/2020 : Cho BroadcastSender Project
        if ("com.example.EXAMPLE_ACTION".equals(intent.getAction())){
            String receiverText = intent.getStringExtra("com.example.EXTRA_TEXT");
            Toast.makeText(context, receiverText, Toast.LENGTH_SHORT).show();
        }*/

        Toast.makeText(context, "EBR triggered", Toast.LENGTH_SHORT).show();
    }
}
