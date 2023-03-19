package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityRecordPeriodicalCleaningBinding
import com.lee.thehungryplaice.databinding.ActivityRecordPostEventCleaningBinding

class RecordPostEventCleaning : AppCompatActivity() {
    private lateinit var binding: ActivityRecordPostEventCleaningBinding
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordPostEventCleaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = findViewById<CardView>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        val date = findViewById<EditText>(R.id.date)
        val name = findViewById<EditText>(R.id.name)
        val fryer = findViewById<CheckBox>(R.id.fryer)
        val bainMarie = findViewById<CheckBox>(R.id.bainMarie)
        val surfaces = findViewById<CheckBox>(R.id.surfaces)
        val shelves = findViewById<CheckBox>(R.id.shelves)
        val walls = findViewById<CheckBox>(R.id.walls)
        val ceiling = findViewById<CheckBox>(R.id.ceiling)
        val flooring = findViewById<CheckBox>(R.id.flooring)
        val coolBoxes = findViewById<CheckBox>(R.id.coolBoxes)
        val utensilsFryerTrays = findViewById<CheckBox>(R.id.utensilsFryerTrays)
        val chipScuttle = findViewById<CheckBox>(R.id.chipScuttle)
        val PPE_FrontCover_TeaTowel = findViewById<CheckBox>(R.id.PPE_FrontCover_TeaTowel)
        val handWashUnit = findViewById<CheckBox>(R.id.handWashUnit)
        val wasteBin = findViewById<CheckBox>(R.id.wasteBin)
        val hotWaterContainer = findViewById<CheckBox>(R.id.hotWaterContainer)

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        submitButton.setOnClickListener{
            if(date.text.toString().trim().isNotEmpty() && name.text.toString().trim().isNotEmpty()
                && fryer.isChecked && bainMarie.isChecked && surfaces.isChecked && shelves.isChecked
                && walls.isChecked && ceiling.isChecked && flooring.isChecked && coolBoxes.isChecked
                && utensilsFryerTrays.isChecked && chipScuttle.isChecked && PPE_FrontCover_TeaTowel.isChecked
                && handWashUnit.isChecked && wasteBin.isChecked && hotWaterContainer.isChecked){

                val sDate = date.text.toString().trim()
                val sName = name.text.toString().trim()

                val postEventCleaningMap = hashMapOf(
                    "Date" to sDate,
                    "Name" to sName,
                    "Fryer" to "Complete",
                    "Bain Marie" to "Complete",
                    "Surfaces" to "Complete",
                    "Shelves" to "Complete",
                    "Walls" to "Complete",
                    "Ceiling" to "Complete",
                    "Flooring" to "Complete",
                    "Cool Boxes" to "Complete",
                    "Utensils / Fryer Trays" to "Complete",
                    "Chip Scuttle" to "Complete",
                    "PPE / Front Cover / Tea Towel" to "Complete",
                    "Hand Wash Unit" to "Complete",
                    "Waste Bin" to "Complete",
                    "Hot Water Container" to "Complete"
                )

                db.collection("Post Event Cleaning").document(sDate).set(postEventCleaningMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Successfully recorded post event cleaning!", Toast.LENGTH_SHORT).show()
                        date.text.clear()
                        name.text.clear()
                        fryer.isChecked = false
                        bainMarie.isChecked = false
                        surfaces.isChecked = false
                        shelves.isChecked = false
                        walls.isChecked = false
                        ceiling.isChecked = false
                        flooring.isChecked = false
                        coolBoxes.isChecked = false
                        utensilsFryerTrays.isChecked = false
                        chipScuttle.isChecked = false
                        PPE_FrontCover_TeaTowel.isChecked = false
                        handWashUnit.isChecked = false
                        wasteBin.isChecked = false
                        hotWaterContainer.isChecked = false
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "Failed to record post event cleaning", Toast.LENGTH_SHORT).show()
                    }
            }
            else {
                Toast.makeText(this, "Complete all the fields", Toast.LENGTH_SHORT).show()
            }

        }

    }
}