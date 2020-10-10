package com.example.buoi11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buoi11.download.FileDownloadManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    private static final int WHAT_FINISH_DOWNLOAD = 1;
    private EditText edtLink;
    private Button btnDownload;
    private String[] PERMISSION = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private boolean checkPermission() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            for (String p : PERMISSION) {
                int status = checkSelfPermission(p);
                if (status == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void requestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(PERMISSION, 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkPermission()){
            initView();
        }else {
            requestPermission();
        }

    }

    private void initView() {
        edtLink = findViewById(R.id.edt_link);
        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String link = edtLink.getText().toString();
        if (link.isEmpty()) {
            Toast.makeText(this, "Link cannot empty", Toast.LENGTH_SHORT).show();
            return;
        }
        v.setEnabled(false);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()){
            initView();
        }else {
            finish();
        }
    }

    @Override
    public void run() {
        String link = edtLink.getText().toString();
        String path = FileDownloadManager.download(link);
        Message msg = new Message();
        msg.what = WHAT_FINISH_DOWNLOAD;
        msg.obj = path;
        handler.sendMessage(msg);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == WHAT_FINISH_DOWNLOAD){
                String path = msg.obj.toString();
                Toast.makeText(MainActivity.this, path, Toast.LENGTH_SHORT).show();
                btnDownload.setEnabled(true);
            }
        }
    };
}