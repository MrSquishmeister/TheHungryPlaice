package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityRecordTemperatureChecksBinding

class RecordTemperatureChecks : AppCompatActivity() {
    private lateinit var binding: ActivityRecordTemperatureChecksBinding
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordTemperatureChecksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val device = findViewById<TextView>(R.id.device)
        val deviceName = intent.getStringExtra("deviceName")
        device.text = (deviceName)

        val date = findViewById<EditText>(R.id.date)
        val time = findViewById<EditText>(R.id.time)
        val temperature = findViewById<EditText>(R.id.temperature)
        val comment = findViewById<EditText>(R.id.comment)
        val checkedBy = findViewById<EditText>(R.id.checkedBy)
        val backButton = findViewById<CardView>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        backButton.setOnClickListener {
            startActivity(Intent(this, TemperatureChecks::class.java))
        }

        submitButton.setOnClickListener{
            val sDevice = device.text.toString().trim()
            val sDate = date.text.toString().trim()
            val sTime = time.text.toString().trim()
            val sTemperature = temperature.text.toString().trim()
            val sComment = comment.text.toString().trim()
            val sCheckedBy = checkedBy.text.toString().trim()



            if (sDevice.isEmpty() || sDate.isEmpty() ||
                sTime.isEmpty() || sTemperature.isEmpty()
                || sComment.isEmpty() || sCheckedBy.isEmpty()){
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else{
                var sType = "";
                if(sDevice.contains("Fridge")){
                    sType = "Fridges"
                }else if(sDevice.contains("Freezer"))
                {
                    sType = "Freezers"
                }

                val temperatureMap = hashMapOf(
                    "Device" to sDevice,
                    "Date" to sDate,
                    "Time" to sTime,
                    "Temperature" to sTemperature,
                    "Comment" to sComment,
                    "Checked By" to sCheckedBy
                )

                db.collection("Temperatures").document(sDate)
                    .collection(sType).document(sDevice).set(temperatureMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Successfully recorded temperatures!", Toast.LENGTH_SHORT).show()
                        date.text.clear()
                        time.text.clear()
                        temperature.text.clear()
                        comment.text.clear()
                        checkedBy.text.clear()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "Failed to record temperatures", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}