package com.example.healthline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityDoctorHomepageBinding

class DoctorHomepage : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDoctorHomepageBinding .inflate(layoutInflater)
        setContentView(binding.root)




        binding.imageView56.setOnClickListener {
            val intent = Intent(this,Reminder::class.java)
            startActivity(intent)
        }
        binding.textView28.setOnClickListener {
            val intent = Intent(this,Reminder::class.java)
            startActivity(intent)
        }



        binding.textView30.setOnClickListener {
            val intent = Intent(this, PatientRequest::class.java)
            startActivity(intent)
        }
        binding.imageView66.setOnClickListener {
            val intent = Intent(this, PatientRequest::class.java)
            startActivity(intent)
        }
        binding.imageView92.setOnClickListener {
            val intent = Intent(this, GetStarted::class.java)
            startActivity(intent)

        }
}}