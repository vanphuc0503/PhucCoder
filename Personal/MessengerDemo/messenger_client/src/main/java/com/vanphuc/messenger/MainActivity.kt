package com.vanphuc.messenger

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vanphuc.messengerdemo.R
import com.vanphuc.messengerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainActivityListener {
    private lateinit var binding: ActivityMainBinding

    private var randomNumberValue: Int? = null
    private var isBound: Boolean? = null
    private var serviceIntent: Intent? = null
    private var randomNumberRequestMessenger: Messenger? = null
    private var randomNumberReceiveMessenger: Messenger? = null

    companion object {
        private const val TAG = "MainActivity"
        private const val GET_RANDOM_NUMBER_FLAG = 0
    }

    @SuppressLint("HandlerLeak")
    inner class ReceiveRandomNumberHandler : Handler() {
        @SuppressLint("SetTextI18n")
        override fun handleMessage(msg: Message) {
            randomNumberValue = 0
            when (msg.what) {
                GET_RANDOM_NUMBER_FLAG -> {
                    randomNumberValue = msg.arg1
                    binding.tvRandomNumber.text = "Random number: $randomNumberValue"
                }
            }
            super.handleMessage(msg)
        }
    }

    private var randomNumberServiceConnection: ServiceConnection? = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            randomNumberRequestMessenger = Messenger(p1)
            randomNumberReceiveMessenger = Messenger(ReceiveRandomNumberHandler())
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            randomNumberReceiveMessenger = null
            randomNumberRequestMessenger = null
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        onSetup()
        serviceIntent = Intent().apply {
            component = ComponentName("com.vanphuc.messenger_service", "com.vanphuc.messenger_service.RemoteService")
            setPackage(packageName)
        }
    }

    private fun onSetup() {
        binding.apply {
            listener = this@MainActivity
        }
    }

    override fun bindService() {
        randomNumberServiceConnection?.let { bindService(serviceIntent, it, BIND_AUTO_CREATE) }
        Log.d(TAG, "bindService ")
    }

    override fun unbindService() {
        randomNumberServiceConnection?.let { unbindService(it) }
        isBound = false
        Log.d(TAG, "unbindService")
    }

    override fun getRandomNumber() {
        if (isBound == true) {
            val requestMessage = Message.obtain(null, GET_RANDOM_NUMBER_FLAG)
            requestMessage.replyTo = randomNumberReceiveMessenger
            try {
                randomNumberRequestMessenger?.send(requestMessage)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        } else {
            Log.d(TAG, "getRandomNumber: Service unbound")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        randomNumberServiceConnection = null
    }
}