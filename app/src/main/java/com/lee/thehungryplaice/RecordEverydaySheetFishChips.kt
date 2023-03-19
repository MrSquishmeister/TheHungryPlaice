package com.lee.thehungryplaice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee.thehungryplaice.databinding.ActivityRecordEverydaySheetFishChipsBinding

class RecordEverydaySheetFishChips : AppCompatActivity() {
    private lateinit var binding: ActivityRecordEverydaySheetFishChipsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordEverydaySheetFishChipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}