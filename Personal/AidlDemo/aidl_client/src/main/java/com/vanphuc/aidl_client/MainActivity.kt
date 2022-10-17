package com.vanphuc.aidl_client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import com.vanphuc.aidldemo.MyAidlInterface

class MainActivity : AppCompatActivity() {
    var aidlColorService: MyAidlInterface? = null

    val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            aidlColorService = MyAidlInterface.Stub.asInterface(p1)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent("AIDLColorServer").apply {
            setPackage("com.vanphuc.aidldemo")
        }

        bindService(intent, connection, BIND_AUTO_CREATE)

        val button = findViewById<Button>(R.id.button_color)
        button.setOnClickListener {
            val color = aidlColorService?.color
            it.setBackgroundColor(color!!)
        }
    }
}