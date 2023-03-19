package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        val backButton = findViewById<Button>(R.id.backButton)
        val fishChipsButton = findViewById<Button>(R.id.fishChipsButton)
        val pizzaButton = findViewById<Button>(R.id.pizzaButton)
        val jacketPotatoesButton = findViewById<Button>(R.id.jacketPotatoesButton)
        val burgersHotdogsButton = findViewById<Button>(R.id.burgersHotdogsButton)

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}