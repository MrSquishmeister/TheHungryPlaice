package com.lee.thehungryplaice

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
        val backButton = findViewById<CardView>(R.id.backButton)
        backButton.setOnClickListener{
            startActivity(Intent(this, SearchData::class.java))
        }

        var day = 1;
        var startMonth = 0
        var endMonth = 0
        var year = 0

        val bundle = intent.extras
        if (bundle != null){
            var sStartMonth = "${bundle.getString("startMonth")}"
            var sEndMonth = "${bundle.getString("endMonth")}"
            var sYear = "${bundle.getString("year")}"

            startMonth = sStartMonth.toInt()
            endMonth = sEndMonth.toInt()
            year = sYear.toInt()
        }

        while (startMonth != endMonth+1){
            fun getPath(): String {
                return if(day < 10) {
                    "0$day:$startMonth:$year"
                }else if(startMonth < 10){
                    "$day:0$startMonth:$year"
                }else if(day < 10 && startMonth < 10){
                    "0$day:0$startMonth:$year"
                }else{
                    "$day:$startMonth:$year"
                }
            }

            while (day != 31){
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
                day += 1
            }
            day = 1
            startMonth += 1
        }
    }
}