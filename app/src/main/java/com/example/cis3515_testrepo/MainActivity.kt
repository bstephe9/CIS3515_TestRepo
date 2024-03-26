package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            Log.d("Countdown", (100 - it).toString())
            delay(1000)
        }
    }
}