package com.example.challange5lukman.Model


import com.google.gson.annotations.SerializedName

data class DataUserResponse(
    @SerializedName("data")
    val `data`: List<DataUserResponseItem>,
    @SerializedName("message")
    val message: String
)