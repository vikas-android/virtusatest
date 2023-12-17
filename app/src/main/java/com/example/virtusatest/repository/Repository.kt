package com.example.virtusatest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.network.ApiService

class Repository(private val apiService: ApiService) {
    private val catLiveData = MutableLiveData<ArrayList<ModelItem>>()

    val cat: LiveData<ArrayList<ModelItem>>
        get() = catLiveData

    suspend fun getCatData(limit: Int) {
        val result = apiService.getCatData(limit)
        if (result?.body() != null) {
            catLiveData.postValue(result.body())
        }
    }
}