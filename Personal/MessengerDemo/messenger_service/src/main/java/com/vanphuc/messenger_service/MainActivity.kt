package com.vanphuc.messenger_service

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var serviceIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickStartService(view: View) {
        serviceIntent = Intent(applicationContext, RemoteService::class.java)
        startService(serviceIntent)
    }

    fun onClickStopService(view: View) {
        stopService(serviceIntent)
    }
}