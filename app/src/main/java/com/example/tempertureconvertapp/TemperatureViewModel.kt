package com.example.tempertureconvertapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TemperatureViewModel : ViewModel() {

    private val _finalRes = MutableLiveData(0.0)
    val finalRes: LiveData<Double>
        get() = _finalRes



    private var resultCom: Double = 0.0

    init {
        fanToCel(0)
        reinitialiseData()
    }

     fun fanToCel(fan:Int): MutableLiveData<Double> {
    var result = 0
    result = fan - 32
    resultCom = result * 0.5556

        _finalRes.value = Math.ceil(resultCom)


    return _finalRes
}

    fun reinitialiseData(){
        _finalRes.value = 0.0
        resultCom = 0.0
    }



}