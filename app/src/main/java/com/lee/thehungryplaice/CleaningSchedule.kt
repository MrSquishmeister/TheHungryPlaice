package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lee.thehungryplaice.databinding.ActivityCleaningScheduleBinding

class CleaningSchedule : AppCompatActivity() {
    private lateinit var binding: ActivityCleaningScheduleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityCleaningScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = findViewById<Button>(R.id.backButton)
        val postEventCleaningButton = findViewById<Button>(R.id.postEventCleaningButton)
        val periodicalCleaningButton = findViewById<Button>(R.id.periodicalCleaningButton)

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        postEventCleaningButton.setOnClickListener{
            startActivity(Intent(this, RecordPostEventCleaning::class.java))
        }

        periodicalCleaningButton.setOnClickListener{
            startActivity(Intent(this, RecordPeriodicalCleaning::class.java))
        }

    }
}