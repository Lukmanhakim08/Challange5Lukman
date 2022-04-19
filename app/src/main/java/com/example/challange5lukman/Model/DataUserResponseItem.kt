package com.example.challange5lukman.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUserResponseItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("no_hp")
    val noHp: String,
    @SerializedName("updated_at")
    val updatedAt: String
): Parcelable