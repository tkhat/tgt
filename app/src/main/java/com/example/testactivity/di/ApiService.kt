package com.example.testactivity.di

import com.example.testactivity.data.model.adapter.CustomDateAdapter
import com.example.testactivity.network.ColorNetwork
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.StringReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiService {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun createColorService(): ColorNetwork {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://www.colourlovers.com/api/colors/")
        retrofitBuilder.client(
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        )
        retrofitBuilder.addConverterFactory(mochiConvertor())

        return retrofitBuilder.build().create(ColorNetwork::class.java)
    }

    private fun mochiConvertor() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .add(CustomDateAdapter())
                .addLast(KotlinJsonAdapterFactory())
                .build()
        ).asLenient()
}