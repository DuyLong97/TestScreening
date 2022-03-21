package com.example.testscreening

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testscreening.Alarm.ringtone
import com.example.testscreening.Alarm.vibrator
import com.example.testscreening.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alarm)

        binding.btnStop.setOnClickListener {
            Log.d("TAG", "onReceive: ringtone ${ringtone.hashCode()}")
            Log.d("TAG", "onReceive: vibrator ${vibrator.hashCode()}")
            ringtone.stop()
            vibrator.cancel()
            finish()
        }
    }
}