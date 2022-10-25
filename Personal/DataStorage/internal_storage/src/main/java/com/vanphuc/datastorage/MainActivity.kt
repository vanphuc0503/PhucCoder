package com.vanphuc.datastorage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vanphuc.datastorage.databinding.ActivityMainBinding
import java.io.*


class MainActivity : AppCompatActivity(), MainActivityListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.listener = this@MainActivity
    }

    override fun saveData() {
        val fileOutputStream: FileOutputStream?

        try {
            fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            fileOutputStream.write(content.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this, "Save data successfully", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun readData() {
        try {
            val input: FileInputStream = openFileInput(fileName)
            val br = BufferedReader(InputStreamReader(input))
            val buffer = StringBuffer()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                buffer.append(line).append("\n")
            }
            Log.d("MainActivity", buffer.toString())
            binding.tvData.text = buffer.toString()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun saveDataByCache() {
        val fileOutputStream: FileOutputStream
        val file: File
        try {
            file = File(cacheDir, fileName)
            Log.d("MainActivity", cacheDir.absolutePath)
            fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(content.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this, "Save data successfully", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun readDataByCache() {
        try {
            val file = File(filesDir, fileName)
            val br = BufferedReader(InputStreamReader(FileInputStream(file)))
            val buffer = StringBuffer()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                buffer.append(line).append("\n")
            }
            Log.d("MainActivity", buffer.toString())
            binding.tvData.text = buffer.toString()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val fileName = "vanphuc0503.com"
        private const val content = "Noi dung duoc chia se thong qua internal storage v2"
    }
}