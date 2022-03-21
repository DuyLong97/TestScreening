package com.example.testscreening

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.testscreening.Alarm.createWaveFormVibrationUsingVibrationEffect
import com.example.testscreening.Alarm.ringtone
import com.example.testscreening.Alarm.startRingtone
import com.example.testscreening.AlarmApplication.Companion.CHANNEL_ID


class AlarmReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        startRingtone(context)
        createWaveFormVibrationUsingVibrationEffect(context)
        Log.d("TAG", "onReceive: ringtone ${ringtone.hashCode()}")
        ringtone.play()

//        val vibratorIntent = Intent(context, VibrateService::class.java)
//        ContextCompat.startForegroundService(context, vibratorIntent)

        val contentIntent = Intent(context, AlarmActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, contentIntent, 0)

        val notificationManager = NotificationManagerCompat.from(context)
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_alarm_on)
            .setContentTitle(context.resources.getString(R.string.alarm_on))
            .setContentText(context.resources.getString(R.string.wake_up))
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
    }
}