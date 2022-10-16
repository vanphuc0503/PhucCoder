package com.vanphuc0503.contentproviderdemo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

    fun onClickAddDetails(view: View?) {

        // class to add values in the database
        val values = ContentValues()

        // fetching text from user
        values.put(
            MyContentProvider.name,
            (findViewById<View>(R.id.textName) as EditText).text.toString()
        )

        // inserting into database through content URI
        contentResolver.insert(MyContentProvider.CONTENT_URI, values)

        // displaying a toast message
        Toast.makeText(baseContext, "New Record Inserted", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("Range")
    fun onClickShowDetails(view: View?) {
        // inserting complete table details in this text field
        val resultView = findViewById<View>(R.id.res) as TextView

        // creating a cursor object of the
        // content URI
        val cursor = contentResolver.query(MyContentProvider.CONTENT_URI, null, null, null, null)

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