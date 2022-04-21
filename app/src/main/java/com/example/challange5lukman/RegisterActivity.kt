package com.example.challange5lukman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.challange5lukman.ViewModel.ViewModelRegister
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (edt_username.text.isNotEmpty() &&
                edt_email.text.isNotEmpty() &&
                edt_password.text.isNotEmpty() &&
                edt_konfirmasi.text.isNotEmpty()){
                if (edt_password.text.toString() != edt_konfirmasi.text.toString()){
                    Toast.makeText(this, "Password dan konfirmasi harus sama", Toast.LENGTH_SHORT).show()
                }else{
                    postRegister()
                    finish()
                }

            }else{
                Toast.makeText(this, "Semua data belum terisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun postRegister(){
        val username = edt_username.text.toString()
        val email = edt_email.text.toString()
        val password = edt_password.text.toString()
        val viewModel = ViewModelProvider(this).get(ViewModelRegister::class.java)
        viewModel.getliveRegisterObserver().observe(this, Observer {
            if (it != null){
                Toast.makeText(this, "Register Sukses", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            }else{
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.RegisterApi(username, email, password)
    }

}