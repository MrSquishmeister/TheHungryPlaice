package com.lee.thehungryplaice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee.thehungryplaice.databinding.ActivityEverydaySheetBinding
import com.lee.thehungryplaice.databinding.ActivityRecordPeriodicalCleaningBinding

class RecordPeriodicalCleaning : AppCompatActivity() {
    private lateinit var binding: ActivityRecordPeriodicalCleaningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordPeriodicalCleaningBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}