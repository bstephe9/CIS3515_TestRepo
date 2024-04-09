package com.example.cis3515_testrepo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log

class TimerService : Service() {

    lateinit var timerHandler : Handler

    var isPaused = false

    inner class TimerBinder : Binder() {
        fun startTimer() {
            runTimer()
        }

        /**
         * Simply toggles `isPaused`.
         */
        fun pauseTimer() {
            isPaused = !isPaused
        }

        fun setHandler(handler: Handler) {
            timerHandler = handler
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return TimerBinder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        runTimer()
        return super.onStartCommand(intent, flags, startId)
    }

    fun runTimer() {
        TimerThread().start()
    }

    override fun onDestroy() {
        Log.d("Service State", "STOPPED")
        super.onDestroy()
    }

    inner class TimerThread() : Thread() {
        override fun run() {
            for (i in 20 downTo 0) {
                while(isPaused); // spin lock
                Log.d("Countdown", i.toString())
                Thread.sleep(250)
            }
            stopSelf()
        }
    }
}