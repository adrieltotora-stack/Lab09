package com.example.lab09.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("users") val users: List<UserModel>
)