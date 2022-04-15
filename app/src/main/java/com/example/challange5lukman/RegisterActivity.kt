package com.example.challange5lukman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challange5lukman.Model.DataPenggunaItem
import com.example.challange5lukman.Model.RequestPengguna
import com.example.challange5lukman.Network.ApiClient
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (edt_nomor.text.isNotEmpty() &&
                edt_username.text.isNotEmpty() &&
                edt_email.text.isNotEmpty() &&
                edt_password.text.isNotEmpty() &&
                edt_konfirmasi.text.isNotEmpty()){

                if (edt_password.text.toString() != edt_konfirmasi.text.toString()){
                    Toast.makeText(this, "Password dan konfirmasi harus sama", Toast.LENGTH_SHORT).show()
                }else{
                    val nomor = edt_nomor.text.toString()
                    val username = edt_username.text.toString()
                    val email = edt_email.text.toString()
                    val password = edt_password.text.toString()
                    registerPengguna(nomor, username, email, password)
                    finish()
                }

            }else{
                Toast.makeText(this, "Semua data belum terisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun registerPengguna(nomor: String, username: String, email: String, password: String){
        ApiClient.instance.register(RequestPengguna(nomor, username, email, password))
            .enqueue(object : Callback<DataPenggunaItem>{
                override fun onResponse(
                    call: Call<DataPenggunaItem>,
                    response: Response<DataPenggunaItem>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<DataPenggunaItem>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}