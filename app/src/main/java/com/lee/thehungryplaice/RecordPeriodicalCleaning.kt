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
    private lateinit var date : EditText
    private lateinit var name : EditText
    private lateinit var fryerRedVan : CheckBox
    private lateinit var fryerBlueVan : CheckBox
    private lateinit var fridgeCleaning : CheckBox
    private lateinit var freezerCleaning : CheckBox
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordPeriodicalCleaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        date = findViewById(R.id.date)
        name = findViewById(R.id.name)
        fryerRedVan = findViewById(R.id.fryerRedVan)
        fryerBlueVan = findViewById(R.id.fryerBlueVan)
        fridgeCleaning = findViewById(R.id.fridgeCleaning)
        freezerCleaning = findViewById(R.id.freezerCleaning)
        val backButton = findViewById<Button>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        backButton.setOnClickListener {
            startActivity(Intent(this, CleaningSchedule::class.java))
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