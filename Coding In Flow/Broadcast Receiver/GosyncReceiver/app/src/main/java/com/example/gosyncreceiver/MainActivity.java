package com.example.gosyncreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        intent.setPackage("com.example.gosync");
        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");
        sendOrderedBroadcast(intent, null, new SenderReceiver(),
                null, 0, "Start", extras);
    }
}