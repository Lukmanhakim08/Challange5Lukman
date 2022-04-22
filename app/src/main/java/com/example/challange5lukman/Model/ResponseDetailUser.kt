package com.example.challange5lukman.Model


import com.google.gson.annotations.SerializedName

data class ResponseDetailUser(
    @SerializedName("detailuser")
    val detailuser: List<Detailuser>
)