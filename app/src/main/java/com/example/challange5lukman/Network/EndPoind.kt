package com.example.challange5lukman.Network

import com.example.challange5lukman.Model.DataPenggunaItem
import com.example.challange5lukman.Model.RequestPengguna
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoind {

    @GET("pengguna")
    fun DetailPengguna() : Call<List<DataPenggunaItem>>

    @POST("pengguna")
    fun register(@Body req : RequestPengguna) : Call<DataPenggunaItem>


}