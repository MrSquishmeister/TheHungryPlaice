package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.lee.thehungryplaice.databinding.ActivitySearchDataBinding

class SearchData : AppCompatActivity() {
    private lateinit var binding: ActivitySearchDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivitySearchDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val backButton = findViewById<CardView>(R.id.backButton)
        val startMonth = findViewById<EditText>(R.id.startMonth)
        val endMonth = findViewById<EditText>(R.id.endMonth)
        val year = findViewById<EditText>(R.id.year)

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        submitButton.setOnClickListener {
            var sStartMonth = startMonth.text.toString()
            var sEndMonth = endMonth.text.toString()
            var sYear = year.text.toString()

            val bundle = Bundle()
            bundle.putString("startMonth", sStartMonth)
            bundle.putString("endMonth", sEndMonth)
            bundle.putString("year", sYear)

            startMonth.text.clear()
            endMonth.text.clear()
            year.text.clear()

            val intent = Intent(this, ViewData::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}