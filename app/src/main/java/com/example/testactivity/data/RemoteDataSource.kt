package com.example.testactivity.data

import com.example.testactivity.data.model.CardDataItem
import com.example.testactivity.network.ColorNetwork
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val colorNetwork: ColorNetwork
) {

    suspend fun getColors(): Response<List<CardDataItem>> {
        return colorNetwork.getColors()
    }
}