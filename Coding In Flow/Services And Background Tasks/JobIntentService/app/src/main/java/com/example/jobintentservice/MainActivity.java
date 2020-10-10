package com.example.jobintentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtInput = findViewById(R.id.edt_input);
    }

    public void enqueueWork(View view) {
        String input = edtInput.getText().toString();

        Intent serviceIntent = new Intent(this, JobIntentService.class);
        serviceIntent.putExtra("inputExtra", input);

        JobIntentService.enqueueWork(this, serviceIntent);
    }
}