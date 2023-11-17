package com.example.healthline


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView7.setOnClickListener {
                            val intent = Intent(this, Register::class.java)
                            startActivity(intent)
                        }

                        binding.button4.setOnClickListener {

                            val email = binding.editTextText.text.toString()
                            val pass = binding.editTextTextPassword4.text.toString()


                            if (email.isNotEmpty() && pass.isNotEmpty()) {

                                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                                    if (it.isSuccessful) {
                        Toast.makeText(applicationContext,"You have Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Homepage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed ! ", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }
}
