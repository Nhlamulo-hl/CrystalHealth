package com.example.healthline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityMedicationViewBinding

class MedicationView : AppCompatActivity() {

    private lateinit var binding: ActivityMedicationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val messages = intent.getStringExtra("message")
        val imageId = intent.getIntExtra("imageId",R.drawable.a)

        binding.textView7.text = name
        binding.textView8.text= messages
        binding.profileImage.setImageResource(imageId)

        binding.imageView90.setOnClickListener {
            val intent = Intent(this, Medication::class.java)
            startActivity(intent)
        }
        binding.button10.setOnClickListener {
            val intent = Intent(this, Billing::class.java)
            startActivity(intent)
        }
    }
}