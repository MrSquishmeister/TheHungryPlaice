package com.lee.thehungryplaice

data class DeviceModel(
    private var date: String,
    private var time: String,
    private var device: String,
    private var temperature: String,
    private var comment: String,
    private var checkedBy: String
){

    fun getDate() : String{
        return date;
    }

    fun setDate(date: String){
        this.date = date
    }

    fun getTime() : String{
        return time;
    }

    fun setTime(time: String){
        this.time = time
    }

    fun getDevice() : String{
        return device;
    }

    fun setDevice(device: String){
        this.device = device
    }

    fun getTemperature() : String{
        return temperature;
    }

    fun setTemperature(temperature: String){
        this.temperature = temperature
    }

    fun getComment() : String{
        return comment;
    }

    fun setComment(comment: String){
        this.comment = comment
    }

    fun getCheckedBy() : String{
        return checkedBy;
    }

    fun setCheckedBy(checkedBy: String){
        this.checkedBy = checkedBy
    }

}


