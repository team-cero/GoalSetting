package com.example.goalsetting

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seekbar for goal setting
        // seekbar max
        seekbar.setProgress(0)
        // seekbar min
        seekbar.setMax(100)

        seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                //called by a knob
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // percentage format
                    val str = String.format(Locale.US, "%d %%", progress)
                    goalNum.text = str
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is touched
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is released
                }

            })

        //timer setting
        startstop.text = "START"

        startstop.setOnClickListener {
            //set time
            var calendar = Calendar.getInstance()
            //get current time with mills second
            calendar.timeInMillis = System.currentTimeMillis()
            //after five second
            calendar.add(Calendar.SECOND,5)

            // create Intent instance
            val intent = Intent(this,AlarmBroadcastReceiver::class.java)
            //setting broadcast to send message
            val pending = PendingIntent.getBroadcast(this,0,intent,0)


            //setting alerm
            var am : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            am.setExact(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pending)
            Toast.makeText(this,"SetAlarm", Toast.LENGTH_SHORT).show()

        }
    }
}
