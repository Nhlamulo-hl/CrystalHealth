package com.example.healthline

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityHomepageBinding

class Homepage : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView49.setOnClickListener {
            val intent = Intent(this, Medication::class.java)
            startActivity(intent)
    }
        binding.imageView46.setOnClickListener {
            val intent = Intent(this, DoctorReminder::class.java)
            startActivity(intent)
        }
        binding.imageView50.setOnClickListener {
            val intent = Intent(this, FindDoctor::class.java)
            startActivity(intent)
        }


        binding.textView16.setOnClickListener {
            val intent = Intent(this, Medication::class.java)
            startActivity(intent)
        }
        binding.textView17.setOnClickListener {
            val intent = Intent(this, DoctorReminder::class.java)
            startActivity(intent)
        }
        binding.textView18.setOnClickListener {
            val intent = Intent(this, FindDoctor::class.java)
            startActivity(intent)
        }


            binding.imageView53.setOnClickListener {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)

}
        binding.imageView87.setOnClickListener {
            val intent = Intent(this, GetStarted::class.java)
            startActivity(intent)
        }

        binding.imageView31.setOnClickListener {
            "https://sbah.org.za/".openUrl()
    }
 }

  private fun String.openUrl() {
      val uri = Uri.parse(this)
      val intent = Intent(Intent.ACTION_VIEW,uri)

      startActivity(intent)
  }

}
