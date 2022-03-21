package com.example.testscreening

import android.content.Context
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.annotation.RequiresApi

object Alarm {
    var alarmUri: Uri? = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
    lateinit var ringtone: Ringtone
    lateinit var vibrator: Vibrator
    fun startRingtone(context: Context) {
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    fun createWaveFormVibrationUsingVibrationEffect(context: Context) {
        vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        Log.d("TAG", "onReceive: vibrator ${vibrator.hashCode()}")
        val mVibratePattern = longArrayOf(0, 200, 500, 200)
        val effect = VibrationEffect.createWaveform(mVibratePattern, 0)
        vibrator.vibrate(effect)
    }
}