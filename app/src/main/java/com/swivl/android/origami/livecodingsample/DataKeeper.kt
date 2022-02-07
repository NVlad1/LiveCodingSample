package com.swivl.android.origami.livecodingsample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object DataKeeper {
    val data = ArrayList<String>()
    val isChecked = HashMap<String, Boolean>()

    suspend fun fetchData(){
        data.clear()
        isChecked.clear()
        mockFetchData()
    }

    private suspend fun mockFetchData(){
        delay(100L)
        for (i in 0 until 1000){
            data.add("data$i")
            isChecked["data$i"] = false
        }
    }
}