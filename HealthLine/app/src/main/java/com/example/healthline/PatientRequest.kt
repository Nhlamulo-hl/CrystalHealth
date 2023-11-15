package com.example.healthline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.healthline.databinding.ActivityPatientRequestBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class PatientRequest : AppCompatActivity() {
    private lateinit var binding:ActivityPatientRequestBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var patient: PatientConfirm
    private lateinit var uid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button15.setOnClickListener {
            val intent = Intent(this, DoctorHomepage::class.java)
            startActivity(intent)
        }


        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("Confirm")

        if(uid.isNotEmpty()){

            getPatientData()
        }

    }

    private fun getPatientData() {
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                patient = snapshot.getValue(PatientConfirm::class.java)!!
                binding.textView36.text = patient.Name
                binding.textView38.text = patient.Appoint
                binding.textView23.text = patient.Number

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}