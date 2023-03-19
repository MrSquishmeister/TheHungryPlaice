package com.lee.thehungryplaice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeviceAdapter(private val deviceList: ArrayList<DeviceModel>) :
        RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val returnedDate : TextView = itemView.findViewById(R.id.returnedDate)
            val returnedTime : TextView = itemView.findViewById(R.id.returnedTime)
            val returnedDevice : TextView = itemView.findViewById(R.id.returnedDevice)
            val returnedTemperature : TextView = itemView.findViewById(R.id.returnedTemperature)
            val returnedComment : TextView = itemView.findViewById(R.id.returnedComment)
            val returnedCheckedBy : TextView = itemView.findViewById(R.id.returnedCheckedBy)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.returned_device_data, parent, false)
        return ViewHolder(v)
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val model: DeviceModel = deviceList[position]
            holder.returnedDate.text = model.getDate()
            holder.returnedTime.text = model.getTime()
            holder.returnedDevice.text = model.getDevice()
            holder.returnedTemperature.text = model.getTemperature()
            holder.returnedComment.text = model.getComment()
            holder.returnedCheckedBy.text = model.getCheckedBy()
        }

        override fun getItemCount(): Int {
            return deviceList.size
        }
}