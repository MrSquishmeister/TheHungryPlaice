package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lee.thehungryplaice.databinding.ActivityRecordPeriodicalCleaningBinding
import com.lee.thehungryplaice.databinding.ActivityRecordPostEventCleaningBinding

class RecordPostEventCleaning : AppCompatActivity() {
    private lateinit var binding: ActivityRecordPostEventCleaningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordPostEventCleaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = findViewById<Button>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        backButton.setOnClickListener {
            startActivity(Intent(this, CleaningSchedule::class.java))
        }
    }
}