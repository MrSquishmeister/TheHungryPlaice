package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityRecordPeriodicalCleaningBinding

class RecordPeriodicalCleaning : AppCompatActivity() {
    private lateinit var binding: ActivityRecordPeriodicalCleaningBinding
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordPeriodicalCleaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val date = findViewById<EditText>(R.id.date)
        val name = findViewById<EditText>(R.id.name)
        val fryerRedVan = findViewById<CheckBox>(R.id.fryerRedVan)
        val fryerBlueVan = findViewById<CheckBox>(R.id.fryerBlueVan)
        val fridgeCleaning = findViewById<CheckBox>(R.id.fridgeCleaning)
        val freezerCleaning = findViewById<CheckBox>(R.id.freezerCleaning)
        val backButton = findViewById<Button>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        submitButton.setOnClickListener{
            if(date.text.toString().trim().isNotEmpty() && name.text.toString().trim().isNotEmpty()
                && fryerRedVan.isChecked && fryerBlueVan.isChecked && fridgeCleaning.isChecked
                && freezerCleaning.isChecked){

                val sDate = date.text.toString().trim()
                val sName = name.text.toString().trim()

                val periodicalCleaningMap = hashMapOf(
                    "Date" to sDate,
                    "Name" to sName,
                    "Fryer Red Van" to "Complete",
                    "Fryer Blue Van" to "Complete",
                    "Fridge Cleaning" to "Complete",
                    "Freezer Cleaning" to "Complete"
                )

                db.collection("periodical cleaning").document(sDate).set(periodicalCleaningMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Successfully recorded periodical cleaning!", Toast.LENGTH_SHORT).show()
                        date.text.clear()
                        name.text.clear()
                        fryerRedVan.isChecked = false
                        fryerBlueVan.isChecked = false
                        fridgeCleaning.isChecked = false
                        freezerCleaning.isChecked = false
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "Failed to record periodical cleaning", Toast.LENGTH_SHORT).show()
                    }
            }
            else {
                Toast.makeText(this, "Complete all the fields", Toast.LENGTH_SHORT).show()
            }

        }

    }
}