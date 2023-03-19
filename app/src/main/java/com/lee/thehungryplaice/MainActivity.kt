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

        val tempButton = findViewById<Button>(R.id.tempButton)

        tempButton.setOnClickListener{
            val Intent = Intent(this, TemperatureChecks::class.java)
            startActivity(Intent)
        }

    }
}