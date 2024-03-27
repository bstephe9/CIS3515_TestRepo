package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Use a coroutine to extract HTML from wikipedia.
         */
        CoroutineScope(Dispatchers.IO).launch {
            val url = URL("https://www.wikipedia.com")

            /**
             * Get all lines of HTML.
             */
            val response = url.openStream().bufferedReader().run {
                val strBuilder = StringBuilder()

                /**
                 * Read each line, append to string builder until line == null.
                 */
                while (readLine().let {
                        strBuilder.append("$it\n")
                        it != null
                    });

                /**
                 * Return the entire string to 'response'.
                 */
                strBuilder.toString()
            }
            Log.d("Response", response)
        }
    }
}