package com.lee.thehungryplaice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee.thehungryplaice.databinding.ActivityEverydaySheetBinding

class EverydaySheet : AppCompatActivity() {
    private lateinit var binding: ActivityEverydaySheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityEverydaySheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}