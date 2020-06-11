package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
//import kotlinx.android.synthetic.main.activity_main.*
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val btnsatu =findViewById(R.id.btnclick) as Button
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)



        binding.btnclick.setOnClickListener{
//            Toast.makeText(this@MainActivity,"tombol berhasil di click",Toast.LENGTH_SHORT)
//                .show()
            val name = binding.inputText.text.toString()
            if (name == null || name.trim() == "")
                Toast.makeText(this@MainActivity, "Ngak Boleh Kosong Kambing !!!", Toast.LENGTH_SHORT).show()
            else{
                binding.textBase.setText(name)

                //change image
                val imaRes = resources.getIdentifier(name,"drawable",packageName)
                binding.imageView1.setImageResource(imaRes)
            }
        }
    }
}