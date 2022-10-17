package com.vanphuc.messenger_service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import kotlin.random.Random

class RemoteService : Service() {
    var randomNumber: Int? = null
    private var isRandomGeneratorOn: Boolean? = null

    companion object {
        private const val TAG = "RemoteService"
        private const val MAX = 100
        private const val GET_RANDOM_NUMBER_FLAG = 0
    }

    @SuppressLint("HandlerLeak")
    private inner class RandomNumberRequestHandler : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                GET_RANDOM_NUMBER_FLAG -> {
                    val messageSendNumber = Message.obtain(null, GET_RANDOM_NUMBER_FLAG)
                    messageSendNumber.arg1 = randomNumber ?: -1
                    try {
                        msg.replyTo.send(messageSendNumber)
                    } catch (ex: Exception) {
                        Log.d(TAG, "handleMessage: ${ex.message}")
                    }
                }
            }
            super.handleMessage(msg)
        }
    }

    private val randomNumberMessenger = Messenger(RandomNumberRequestHandler())

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind")
        if (intent?.`package`.equals("com.vanphuc.messenger_service")) {
            Log.d(TAG, "onBind: Correct package")
            return randomNumberMessenger.binder
        } else {
            Log.d(TAG, "onBind: Wrong package")
        }
        return null // Option1
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand, thread id: ${Thread.currentThread().id}")
        isRandomGeneratorOn = true
        Thread {
            startRandomNumberGenerator()
        }.start()
        return START_STICKY
    }

    private fun startRandomNumberGenerator() {
        while (isRandomGeneratorOn == true) {
            try {
                Thread.sleep(1000)
                if (isRandomGeneratorOn == true) {
                    randomNumber = Random.nextInt(MAX)
                    Log.d(
                        TAG,
                        "startRandomNumberGenerator, thread id: ${Thread.currentThread().id}, Random Number: $randomNumber"
                    )
                }
            } catch (e: Exception) {
                Log.d(
                    TAG,
                    "startRandomNumberGenerator Thread Interrupted, thread id: ${Thread.currentThread().id}"
                )
            }
        }
    }

    private fun stopRandomNumberGenerator() {
        Log.d(TAG, "stopRandomNumberGenerator")
        isRandomGeneratorOn = false
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind")
    }

    override fun onDestroy() {
        super.onDestroy()
        stopRandomNumberGenerator()
        Log.d(TAG, "onDestroy")
    }
}