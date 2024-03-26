package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var timerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)

        /**
         * Define scope for coroutine.
         *
         * For the scope's context, call the Job() constructor and specify that the Default
         * dispatcher will execute this coroutine.
         */
        val scope = CoroutineScope(Job() + Dispatchers.Default)

        /**
         * Launch the coroutine.
         */
        scope.launch {
            countdownTimer()
        }
    }

    suspend fun countdownTimer() {
        repeat(100) {
            (100 - it).toString().run {
                Log.d("Countdown", this)
                timerTextView.text = this
            }
            delay(1000)
        }
    }
}