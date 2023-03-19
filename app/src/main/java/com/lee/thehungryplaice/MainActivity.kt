package com.lee.thehungryplaice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
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

        val temperatureChecks = findViewById<CardView>(R.id.temperatureChecks)
        val postEventCleaning = findViewById<CardView>(R.id.postEventCleaning)
        val periodicalCleaning = findViewById<CardView>(R.id.periodicalCleaning)
        val eventDayFishChips = findViewById<CardView>(R.id.eventDayFishChips)
        val evenDayPizza = findViewById<CardView>(R.id.eventDayPizza)
        val eventDayJacketPotatoes = findViewById<CardView>(R.id.eventDayJacketPotatoes)
        val eventDayBurgersHotdogs = findViewById<CardView>(R.id.eventDayBurgersHotdogs)
        val viewData = findViewById<CardView>(R.id.viewData)

        temperatureChecks.setOnClickListener{
            startActivity(Intent(this, TemperatureChecks::class.java))
        }

        postEventCleaning.setOnClickListener{
            startActivity(Intent(this, RecordPostEventCleaning::class.java))
        }

        periodicalCleaning.setOnClickListener{
            startActivity(Intent(this, RecordPeriodicalCleaning::class.java))
        }

        eventDayFishChips.setOnClickListener{
            startActivity(Intent(this, RecordEverydaySheetFishChips::class.java))
        }

        viewData.setOnClickListener {
            startActivity(Intent(this, ViewData::class.java))
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://console.firebase.google.com/project/the-hungry-plaice/firestore/data")
//            startActivity(openURL)
        }


    }
}