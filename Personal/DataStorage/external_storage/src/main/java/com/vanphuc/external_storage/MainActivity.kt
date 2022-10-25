package com.vanphuc.external_storage

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.vanphuc.external_storage.databinding.ActivityMainBinding
import java.io.*


class MainActivity : AppCompatActivity(), MainActivityListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.listener = this@MainActivity
        checkAndRequestPermissions()
    }

    private fun checkAndRequestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                listPermissionsNeeded.add(permission)
            }
        }
        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(), 1)
        }
    }

    override fun saveData() {
        val content = "Blog chia se kien thuc lap trinh"
        val file: File
        val outputStream: FileOutputStream
        try {
            file = File(Environment.getExternalStorageDirectory(), "vanphuc0503.com")
            if (!file.exists()) file.mkdirs()
            Log.d("MainActivity", Environment.getExternalStorageDirectory().absolutePath)
            Log.d("MainActivity", getExternalFilesDir("Phuc")!!.absolutePath)
            Log.d(
                "MainActivity",
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
            )
            outputStream = FileOutputStream(file)
            outputStream.write(content.toByteArray())
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun readData() {
        val input: BufferedReader?
        val file: File?
        try {
            file = File(Environment.getExternalStorageDirectory(), "vanphuc0503.com")
            input = BufferedReader(InputStreamReader(FileInputStream(file)))
            var line: String?
            val buffer = StringBuffer()
            while (input.readLine().also { line = it } != null) {
                buffer.append(line)
            }
            Log.d("MainActivity", buffer.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}