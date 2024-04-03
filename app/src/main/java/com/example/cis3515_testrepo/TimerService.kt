package com.example.cis3515_testrepo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        runTimer()
        return super.onStartCommand(intent, flags, startId)
    }

    fun runTimer() {
        Thread {
            for (i in 50 downTo 0) {
                Log.d("Countdown", i.toString())
                Thread.sleep(100)
            }
            stopSelf()
        }.start()
    }
}