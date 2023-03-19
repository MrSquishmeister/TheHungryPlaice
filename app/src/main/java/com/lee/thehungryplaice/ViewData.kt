package com.lee.thehungryplaice

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lee.thehungryplaice.databinding.ActivityViewDataBinding

class ViewData : AppCompatActivity() {
    private lateinit var binding: ActivityViewDataBinding
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        binding = ActivityViewDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val backButton = findViewById<CardView>(R.id.backButton)
        val startMonth = findViewById<EditText>(R.id.startMonth)
        val endMonth = findViewById<EditText>(R.id.endMonth)
        val year = findViewById<EditText>(R.id.year)

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        submitButton.setOnClickListener {
            var sStartMonth = startMonth.text.toString().toInt()
            var sEndMonth = endMonth.text.toString().toInt()
            var sYear = year.text.toString().toInt()

            var sDay = 1;

            while (sStartMonth != sEndMonth+1){
                fun getPath(): String {
                    return if(sDay < 10) {
                        "0$sDay:$sStartMonth:$sYear"
                    }else if(sStartMonth < 10){
                        "$sDay:0$sStartMonth:$sYear"
                    }else if(sDay < 10 && sStartMonth < 10){
                        "0$sDay:0$sStartMonth:$sYear"
                    }else{
                        "$sDay:$sStartMonth:$sYear"
                    }
                }

                while (sDay != 31){
                    db.collection(getPath())
                        .get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                                val dataList = ArrayList<DeviceModel>()
                                dataList.add(DeviceModel(
                                    document.data["Date"] as String, document.data["Time"] as String,
                                    document.data["Device"] as String, document.data["Temperature"] as String,
                                    document.data["Comment"] as String, document.data["Checked By"] as String))
                                val deviceAdapter = DeviceAdapter(dataList)
                                recyclerView.adapter = deviceAdapter
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                    sDay += 1
                }
                sDay = 1
                sStartMonth += 1
            }
        }
    }
}