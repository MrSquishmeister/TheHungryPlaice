package com.lee.thehungryplaice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityRecordTemperatureChecksBinding

class RecordTemperatureChecks : AppCompatActivity() {
    private lateinit var binding: ActivityRecordTemperatureChecksBinding
    private lateinit var device : TextView
    private lateinit var date : EditText
    private lateinit var time : EditText
    private lateinit var temperature : EditText
    private lateinit var comment : EditText
    private lateinit var checkedBy : EditText

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityRecordTemperatureChecksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        device = findViewById(R.id.device)
        val deviceName = intent.getStringExtra("deviceName")
        device.text = (deviceName)

        date = findViewById(R.id.date)
        time = findViewById(R.id.time)
        temperature = findViewById(R.id.temperature)
        comment = findViewById(R.id.comment)
        checkedBy = findViewById(R.id.checkedBy)
        val backButton = findViewById<Button>(R.id.backButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        backButton.setOnClickListener {
            startActivity(Intent(this, TemperatureChecks::class.java))
        }

        submitButton.setOnClickListener{

            if (device.text.toString().trim().isEmpty() || date.text.toString().trim().isEmpty() ||
                time.text.toString().trim().isEmpty() || temperature.text.toString().trim().isEmpty()
                || comment.text.toString().trim().isEmpty() || checkedBy.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val sDevice = device.text.toString().trim()
                val sDate = date.text.toString().trim()
                val sTime = time.text.toString().trim()
                val sTemperature = temperature.text.toString().trim()
                val sComment = comment.text.toString().trim()
                val sCheckedBy = checkedBy.text.toString().trim()

                val temperatureMap = hashMapOf(
                    "Device" to sDevice,
                    "Date" to sDate,
                    "Time" to sTime,
                    "Temperature" to sTemperature,
                    "Comment" to sComment,
                    "Checked By" to sCheckedBy
                )

                db.collection("Temperatures").document(sDevice)
                    .collection(sDevice).document(sDate).set(temperatureMap)
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