package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempButton = findViewById<Button>(R.id.tempButton)

        tempButton.setOnClickListener{
            val Intent = Intent(this, TemperatureChecks::class.java)
            startActivity(Intent)
        }

    }
}