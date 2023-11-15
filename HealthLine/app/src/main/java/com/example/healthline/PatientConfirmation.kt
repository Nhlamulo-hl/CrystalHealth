package com.example.healthline

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityPatientConfirmationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PatientConfirmation : AppCompatActivity() {

    private lateinit var binding:ActivityPatientConfirmationBinding
    private lateinit var  auth: FirebaseAuth
    private lateinit var  databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Confirm")

        binding.btnConfirm.setOnClickListener {

            val name = binding.editTextTextPersonName6.text.toString()
            val appoint=binding.editTextTextPersonName17.text.toString()
            val number=binding.editTextTextPersonName18.text.toString()
val user =PatientConfirm(name,appoint,number)


            if(uid !=null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this@PatientConfirmation,"Successfully updated profile", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Homepage::class.java)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this@PatientConfirmation,"Failed to update profile", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }





    }
}