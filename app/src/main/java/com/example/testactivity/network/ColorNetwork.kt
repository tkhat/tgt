package com.example.testactivity.network

import com.example.testactivity.data.model.CardDataItem
import retrofit2.Response
import retrofit2.http.GET

interface ColorNetwork {

    @GET("colors/new?format=json")
    suspend fun getColors(): Response<List<CardDataItem>>
}