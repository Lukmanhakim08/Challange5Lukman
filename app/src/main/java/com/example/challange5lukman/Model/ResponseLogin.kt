package com.example.challange5lukman.Model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("responseuser")
    val responseuser: Responseuser
)