package com.example.challange5lukman.Network

import com.example.challange5lukman.Model.*
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
    ): Call<Responseuser>

    @POST("updateUser.php")
    @FormUrlEncoded
    fun updateUser(
        @Field("id") id: String,
        @Field("complete_name") complete_name: String,
        @Field("username") username: String,
        @Field("address") address: String,
        @Field("dateofbirth") dateofbirth: String
    ): Call<Responseuser>

    @POST("detailuser.php")
    @FormUrlEncoded
    fun detailUser(
        @Field("id") id: Int
    ): Call<List<Detailuser>>

}
