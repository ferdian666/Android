package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.test.databinding.ActivityMainBinding
import com.example.test.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
    binding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

    binding.Submit.setOnClickListener {
        val username =binding.Username.text.toString()
        val password =binding.Password.text.toString()

        if (username.isEmpty()){
            Username.setError("Masukan Email Anda !")
        }
        else if (password.isEmpty()){
            Password.setError("Masukan Password Anda !")
        }
        else if (username.isEmpty() && password.isEmpty()){
            Toast.makeText(this@RegisterActivity,"Inputannya Kosong Bos", Toast.LENGTH_SHORT).show();
        }
        else if (! (username.isEmpty() && password.isEmpty())){
            auth.createUserWithEmailAndPassword(username,password).addOnCompleteListener { task->
                if (task.isSuccessful){
                    Toast.makeText(this@RegisterActivity,"Selamat Datang !",Toast.LENGTH_SHORT).show();
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@RegisterActivity,"Gagal Boss !",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    }
}