package com.example.devassessment.api.responsemodel

import com.google.gson.annotations.SerializedName

data class UserResponse (
        @SerializedName("id") var id : String,
        @SerializedName("fullName") var fullName : String,
        @SerializedName("aviUrl") var aviUrl: String,
        @SerializedName("gender")var gender: String,
        @SerializedName("createdAt")var createdAt: String,
        @SerializedName("colours")var colours : List<String>,
        @SerializedName("countries")var countries: List<String>
)