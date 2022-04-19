package com.example.challange5lukman.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUserRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("no_hp")
    val noHp: String,
    @SerializedName("password")
    val password: String
): Parcelable
