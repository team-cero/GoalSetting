package com.example.goalsetting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
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
    }
}
