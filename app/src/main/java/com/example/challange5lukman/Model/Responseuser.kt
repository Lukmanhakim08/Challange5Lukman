package com.example.challange5lukman.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Responseuser(
    @SerializedName("id")
    val id: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("complete_name")
    val completeName: String,
    @SerializedName("dateofbirth")
    val dateofbirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
) : Parcelable