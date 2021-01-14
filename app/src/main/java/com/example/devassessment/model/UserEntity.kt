package com.example.devassessment.model

data class UserEntity (
        var id : String,
        var fullName : String,
        var avi: String,
        var gender: String,
        var createdAt: String,
        var colours : List<String>,
        var countries: List<String>
)