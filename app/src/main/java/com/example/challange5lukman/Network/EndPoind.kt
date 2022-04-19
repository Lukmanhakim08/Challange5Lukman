package com.example.challange5lukman.Network

import com.example.challange5lukman.Model.DataPenggunaItem
import com.example.challange5lukman.Model.DataUserRequest
import com.example.challange5lukman.Model.DataUserResponseItem
import com.example.challange5lukman.Model.RequestPengguna
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoind {

    @GET("user")
    fun GetAllDataUser() : Call<List<DataUserResponseItem>>

    @POST("register")
    fun register(
        @Field("no_hp") no_hp: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseBody>
//    fun register(@Body req : DataUserRequest) : Call<DataUserResponseItem>


}