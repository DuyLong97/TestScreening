package com.example.testscreening

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi


class VibrateService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ServiceStarted", "Service is started using NotificationSetter")
        Alarm.createWaveFormVibrationUsingVibrationEffect(applicationContext)
        return START_STICKY
    }
}