package com.vanphuc0503.content_receiver

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val contentUri = Uri.parse("content://com.vanphuc0503.provider/users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("Range")
    fun onClickShowDetails(view: View?) {
        // inserting complete table details in this text field
        val resultView = findViewById<View>(R.id.res) as TextView

        // creating a cursor object of the
        // content URI
        val cursor = contentResolver.query(contentUri, null, null, null, null)

        // iteration of the cursor
        // to print whole table
        if (cursor?.moveToFirst() == true) {
            val strBuild = StringBuilder()
            while (!cursor.isAfterLast) {
                strBuild.append(
                    """ 
      
    ${cursor.getString(cursor.getColumnIndex("id"))}-${cursor.getString(cursor.getColumnIndex("name"))} 
    """.trimIndent()
                )
                cursor.moveToNext()
            }
            resultView.text = strBuild
        } else {
            resultView.text = "No Records Found"
        }
    }
}