package com.example.challange5lukman.Model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginPengguna(

    @SerializedName("email")
    @Expose
    var email: String? = null ,

    @SerializedName("password")
    @Expose
    var password: String? = null

): Parcelable