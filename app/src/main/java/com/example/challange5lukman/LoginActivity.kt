package com.example.challange5lukman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.challange5lukman.Model.ResponseLogin
import com.example.challange5lukman.Model.Responseuser
import com.example.challange5lukman.Network.ApiClient
import com.example.challange5lukman.ViewModel.ViewModelRegister
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val datauser = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
//        if(datauser.contains("EMAIL")){
//            startActivity(Intent(this, HomeActivity::class.java))
//        }

        sharedPreferences = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        btn_login.setOnClickListener {
           if (et_email.text.toString().isEmpty()){
               et_email.setError("Isi email")
           }else if (et_password.text.toString().isEmpty()){
               et_password.setError("Isi Password")
           }else{
               doLogin()
           }

        }

        text_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun doLogin(){
        val email = et_email.text.toString()
        val pass = et_password.text.toString()
        val viewmodel = ViewModelProvider(this).get(ViewModelRegister::class.java)
        viewmodel.getLiveLoginObserver().observe(this, Observer {
            if (it != null){
                val preft = sharedPreferences.edit()
                preft.putString("id", it.id)
                preft.putString("ID", it.id)
                preft.putString("NMLENGKAP", it.completeName)
                preft.putString("USERNAME", it.username)
                preft.putString("TGL", it.dateofbirth)
                preft.putString("ALAMAT", it.address)
                preft.putString("EMAIL", email)
                preft.apply()

                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "email dan password salah", Toast.LENGTH_SHORT).show()
            }
        })
        viewmodel.LoginApi(email, pass)
    }

}