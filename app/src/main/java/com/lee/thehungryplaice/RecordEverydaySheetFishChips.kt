package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityRecordEverydaySheetFishChipsBinding

class RecordEverydaySheetFishChips : AppCompatActivity() {
    private lateinit var binding: ActivityRecordEverydaySheetFishChipsBinding
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordEverydaySheetFishChipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val backButton = findViewById<CardView>(R.id.backButton)
        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        val fishXDFDate = findViewById<EditText>(R.id.fishXDFDate)
        val fishXDFTime = findViewById<EditText>(R.id.fishXDFTime)
        val fishFridge2Date = findViewById<EditText>(R.id.fishFridge2Date)
        val fishFridge2Time = findViewById<EditText>(R.id.fishFridge2Time)
        val fishInCoolBox1Date = findViewById<EditText>(R.id.fishInCoolBox1Date)
        val fishInCoolBox1Time = findViewById<EditText>(R.id.fishInCoolBox1Time)
        val fishInCoolBox2Date = findViewById<EditText>(R.id.fishInCoolBox2Date)
        val fishInCoolBox2Time = findViewById<EditText>(R.id.fishInCoolBox2Time)
        val fishEventCoolBox1Date = findViewById<EditText>(R.id.fishEventCoolBox1Date)
        val fishEventCoolBox1Time = findViewById<EditText>(R.id.fishEventCoolBox1Time)
        val fishEventCoolBox2Date = findViewById<EditText>(R.id.fishEventCoolBox2Date)
        val fishEventCoolBox2Time = findViewById<EditText>(R.id.fishEventCoolBox2Time)

        submitButton.setOnClickListener{
            val sfishXDFDate = fishXDFDate.text.toString().trim()
            val sfishXDFTime = fishXDFTime.text.toString().trim()
            val sfishFridge2Date = fishFridge2Date.text.toString().trim()
            val sfishFridge2Time = fishFridge2Time.text.toString().trim()
            val sfishInCoolBox1Date = fishInCoolBox1Date.text.toString().trim()
            val sfishInCoolBox1Time = fishInCoolBox1Time.text.toString().trim()
            val sfishInCoolBox2Date = fishInCoolBox2Date.text.toString().trim()
            val sfishInCoolBox2Time = fishInCoolBox2Time.text.toString().trim()
            val sfishEventCoolBox1Date = fishEventCoolBox1Date.text.toString().trim()
            val sfishEventCoolBox1Time = fishEventCoolBox1Time.text.toString().trim()
            val sfishEventCoolBox2Date = fishEventCoolBox2Date.text.toString().trim()
            val sfishEventCoolBox2Time = fishEventCoolBox2Time.text.toString().trim()

            if(sfishXDFDate.isEmpty() || sfishXDFTime.isEmpty() || sfishFridge2Date.isEmpty()
                || sfishFridge2Time.isEmpty() || sfishInCoolBox1Date.isEmpty() || sfishInCoolBox1Time.isEmpty()
                || sfishInCoolBox2Date.isEmpty() || sfishInCoolBox2Time.isEmpty() || sfishEventCoolBox1Date.isEmpty()
                || sfishEventCoolBox1Time.isEmpty() || sfishEventCoolBox2Date.isEmpty() || sfishEventCoolBox2Time.isEmpty() ){
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val fishMap = hashMapOf(
                    "fishXDFDate" to sfishXDFDate,
                    "fishXDFTime" to sfishXDFTime,
                    "fishFridge2Date" to sfishFridge2Date,
                    "fishFridge2Time" to sfishFridge2Time,
                    "fishInCoolBox1Date" to sfishInCoolBox1Date,
                    "fishInCoolBox1Time" to sfishInCoolBox1Time,
                    "fishInCoolBox2Date" to sfishInCoolBox2Date,
                    "fishInCoolBox2Time" to sfishInCoolBox2Time,
                    "fishEventCoolBox1Date" to sfishEventCoolBox1Date,
                    "fishEventCoolBox1Time" to sfishEventCoolBox1Time,
                    "fishEventCoolBox2Date" to sfishEventCoolBox2Date,
                    "fishEventCoolBox2Time" to sfishEventCoolBox2Time
                )

                db.collection("Everyday Fish&Chips").document("fish").set(fishMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Successfully recorded everyday fish&chips!", Toast.LENGTH_SHORT).show()
                        fishXDFDate.text.clear()
                        fishXDFTime.text.clear()
                        fishFridge2Date.text.clear()
                        fishFridge2Time.text.clear()
                        fishInCoolBox1Date.text.clear()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "Failed to record everyday fish&chips", Toast.LENGTH_SHORT).show()
                    }

            }
        }



    }
}