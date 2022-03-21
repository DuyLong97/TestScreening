package com.example.testscreening

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.testscreening.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnSetAlarm.setOnClickListener { addAlarm() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addAlarm() {
        val cal = Calendar.getInstance()
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show()
        cal.set(Calendar.HOUR_OF_DAY, binding.timePicker.hour)
        cal.set(Calendar.MINUTE, binding.timePicker.minute)
        cal.set(Calendar.SECOND, 0)
        val alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(this, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }
        val info = AlarmManager.AlarmClockInfo(cal.timeInMillis, alarmIntent)
        alarmMgr.setAlarmClock(info, alarmIntent)
    }
}