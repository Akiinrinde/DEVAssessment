package com.example.devassessment.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://android-json-test-api.herokuapp.com"

    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain->
                val original = chain.request()

                val requestBuilder = original.newBuilder().method(original.method(), original.body())
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()

    val instance: ApiServices by lazy {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        retrofit.create(ApiServices::class.java)
    }
}