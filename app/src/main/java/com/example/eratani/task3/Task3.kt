package com.example.eratani.task3

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.eratani.R
import kotlinx.android.synthetic.main.activity_task3.*


class Task3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        seekBar2.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar, progressValue: Int, fromUser: Boolean
                ) {
                    val animation = AnimationUtils.loadAnimation(this@Task3, R.anim.zoom)
                    animation.duration = 5000 - (progressValue.toLong() * 800)
                    ivHeart.startAnimation(animation)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })





    }
}