package com.example.challange5lukman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challange5lukman.Network.ApiClient
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import mumtaz.binar.challangechapterlima.model.ResponseLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
//            startActivity(Intent(this, HomeActivity::class.java))
            if (et_email.text.isNotEmpty() &&
                et_password.text.isNotEmpty() ){
                val email = et_email.text.toString()
                val pass = et_password.text.toString()
                setLogin(email, pass)
                val pindah = Intent(this, HomeActivity::class.java)
                pindah.putExtra("dataUser", setLogin(email, pass).toString())
                startActivity(pindah)
                finish()
            }else{
                Toast.makeText(this, "Email dan Pasword wajib diisi", Toast.LENGTH_SHORT).show()
            }

        }

        text_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun setLogin(email: String, password: String){
        ApiClient.instance.loginUser(email, password)
            .enqueue(object : Callback<ResponseLogin>{
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if (response.isSuccessful){
//                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        Toast.makeText(this@LoginActivity, "Login Sukses", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@LoginActivity, "Password atau Email Salah", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
                }

            })
    }

}