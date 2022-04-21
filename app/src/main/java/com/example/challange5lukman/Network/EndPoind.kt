package com.example.challange5lukman.Network

import com.example.challange5lukman.Model.DatafilmResponseItem
import com.example.challange5lukman.Model.ResponseLogin
import com.example.challange5lukman.Model.ResponseRegister
import com.example.challange5lukman.Model.Responseuser
import retrofit2.Call
import retrofit2.http.*

interface EndPoind {

    @GET("apifilm.php")
    fun GetDatafilm() : Call<List<DatafilmResponseItem>>

    @POST("register.php")
    @FormUrlEncoded
    fun addRegister(
        @Field ("username") username: String,
        @Field ("email") email: String,
        @Field ("password") pasword: String,
    ): Call<ResponseRegister>

    @POST("login.php")
    @FormUrlEncoded
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseLogin>

//    @POST("updateUser.php")
//    @FormUrlEncoded
//    fun updateUser(
//
//    )

}
