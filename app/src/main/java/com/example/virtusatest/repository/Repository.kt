package com.example.virtusatest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    private val catLiveData = MutableLiveData<NetworkResult<ArrayList<ModelItem>>>()

    val cat: LiveData<NetworkResult<ArrayList<ModelItem>>>
        get() = catLiveData

    suspend fun getCatData(limit: Int) {
        try {
            val result = apiService.getCatData(limit)
            if (result?.body() != null) {
                catLiveData.postValue(NetworkResult.Success(result.body()))
            } else {
                catLiveData.postValue(NetworkResult.Error("Something Went wrong"))
            }
        } catch (e: Exception) {
            catLiveData.postValue(NetworkResult.Error(e.message.toString()))
        }
    }
}