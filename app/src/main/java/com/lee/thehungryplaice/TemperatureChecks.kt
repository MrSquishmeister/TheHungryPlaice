package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lee.thehungryplaice.databinding.ActivityTemperatureChecksBinding

class TemperatureChecks : AppCompatActivity() {
    private lateinit var binding: ActivityTemperatureChecksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityTemperatureChecksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = findViewById<Button>(R.id.backButton)
        val fridge1Button = findViewById<Button>(R.id.fridge1Button)
        val fridge2Button = findViewById<Button>(R.id.fridge2Button)
        val freezer1Button = findViewById<Button>(R.id.freezer1Button)
        val freezer2Button = findViewById<Button>(R.id.freezer2Button)
        val freezer3Button = findViewById<Button>(R.id.freezer3Button)
        val freezer4Button = findViewById<Button>(R.id.freezer4Button)
        val freezer5Button = findViewById<Button>(R.id.freezer5Button)

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        fridge1Button.setOnClickListener{
            callActivity("Fridge1")
        }
        fridge2Button.setOnClickListener{
            callActivity("Fridge2")
        }
        freezer1Button.setOnClickListener{
            callActivity("Freezer1")
        }
        freezer2Button.setOnClickListener{
            callActivity("Freezer2")
        }
        freezer3Button.setOnClickListener{
            callActivity("Freezer3")
        }
        freezer4Button.setOnClickListener{
            callActivity("Freezer4")
        }
        freezer5Button.setOnClickListener{
            callActivity("Freezer5")
        }

    }
    private fun callActivity(deviceName: String){
        startActivity(Intent(this, RecordTemperatureChecks::class.java)
            .putExtra("deviceName", deviceName))
    }
}