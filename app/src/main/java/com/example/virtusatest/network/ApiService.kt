package com.example.virtusatest.network

import com.example.virtusatest.model.Model
import com.example.virtusatest.model.ModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/images/search")
    suspend fun getCatData(@Query("limit") limit: Int):Response<ArrayList<ModelItem>>
}