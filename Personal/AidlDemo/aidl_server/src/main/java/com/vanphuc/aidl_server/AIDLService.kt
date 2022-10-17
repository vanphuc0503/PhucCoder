package com.vanphuc.aidl_server

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import com.vanphuc.aidldemo.MyAidlInterface
import kotlin.random.Random

class AIDLService : Service() {

    private val binder = object : MyAidlInterface.Stub() {
        override fun getColor(): Int {
            val randomColor = Random
            return Color.argb(
                255,
                randomColor.nextInt(),
                randomColor.nextInt(),
                randomColor.nextInt()
            )
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}