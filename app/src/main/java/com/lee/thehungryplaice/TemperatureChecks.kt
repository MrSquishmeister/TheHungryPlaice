package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TemperatureChecks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_checks)

        val fridge1Button = findViewById<Button>(R.id.fridge1Button)

        fridge1Button.setOnClickListener{
            val deviceName = ("Fridge1")
            callActivity(deviceName)
        }
    }
    private fun callActivity(deviceName: String){
       startActivity(Intent(this, RecordTemperatureChecks::class.java)
           .putExtra("deviceName", deviceName))
    }
}