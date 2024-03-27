package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textDisplay = findViewById<TextView>(R.id.textDisplay)

        Volley.newRequestQueue(this)
            .add(StringRequest(Request.Method.GET, "https://www.wikipedia.com", {
                textDisplay.text = it
            }, {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            })  )
    }
}