package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lee.thehungryplaice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val temperatureChecksButton = findViewById<Button>(R.id.temperatureCheckButton)
        val everydaySheetButton = findViewById<Button>(R.id.everydaySheetButton)
        val cleaningScheduleButton = findViewById<Button>(R.id.cleaningScheduleButton)

        temperatureChecksButton.setOnClickListener{
            startActivity(Intent(this, TemperatureChecks::class.java))
        }

        everydaySheetButton.setOnClickListener{
            startActivity(Intent(this, EverydaySheet::class.java))
        }

        cleaningScheduleButton.setOnClickListener{
            startActivity(Intent(this, CleaningSchedule::class.java))
        }

    }
}