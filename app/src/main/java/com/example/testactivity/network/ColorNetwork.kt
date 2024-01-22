package com.example.testactivity.network

import com.example.testactivity.data.model.CardData
import retrofit2.Response
import retrofit2.http.GET

interface ColorNetwork {

    @GET("new?format=json/")
    suspend fun getColors(): Response<CardData>
}