package com.example.devassessment.api

import com.example.devassessment.api.responsemodel.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("/accounts")
    fun getUserDetails():Call<List<UserResponse>>
}