package com.example.challange5lukman.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPenggunaItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("nomor")
    val nomor: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
): Parcelable