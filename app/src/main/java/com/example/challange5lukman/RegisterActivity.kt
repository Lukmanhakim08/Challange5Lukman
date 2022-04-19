package com.example.challange5lukman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challange5lukman.Model.DataPenggunaItem
import com.example.challange5lukman.Model.DataUserRequest
import com.example.challange5lukman.Model.DataUserResponseItem
import com.example.challange5lukman.Model.RequestPengguna
import com.example.challange5lukman.Network.ApiClient
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (edt_username.text.isNotEmpty() &&
                edt_email.text.isNotEmpty() &&
                edt_nomor.text.isNotEmpty() &&
                edt_password.text.isNotEmpty() &&
                edt_konfirmasi.text.isNotEmpty()){
                if (edt_password.text.toString() != edt_konfirmasi.text.toString()){
                    Toast.makeText(this, "Password dan konfirmasi harus sama", Toast.LENGTH_SHORT).show()
                }else{
                    val email = edt_email.text.toString()
                    val name = edt_username.text.toString()
                    val no_hp = edt_nomor.text.toString()
                    val password = edt_password.text.toString()
                    registerPengguna(email, name, no_hp, password)
                    finish()
                }

            }else{
                Toast.makeText(this, "Semua data belum terisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun registerPengguna(email: String, name: String, no_hp: String, password: String){
        ApiClient.instance.register(email, name, no_hp, password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}