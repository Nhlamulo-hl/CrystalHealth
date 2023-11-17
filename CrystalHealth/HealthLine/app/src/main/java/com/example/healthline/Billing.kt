package com.example.healthline

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityBillingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Billing : AppCompatActivity() {
    private lateinit var binding: ActivityBillingBinding
    private lateinit var  auth: FirebaseAuth
    private lateinit var  databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Billing")


        binding.imageView30.setOnClickListener {
            val intent = Intent(this, MedicationView::class.java)
            startActivity(intent)
}
        binding.button6.setOnClickListener {

            val name = binding.editTextTextPersonName2.text.toString()
            val lastname=binding.editTextTextPersonName8.text.toString()
            val address=binding.editTextTextPersonName.text.toString()
            val suburb=binding.editTextTextPersonName13.text.toString()
            val town=binding.editTextTextPersonName14.text.toString()
            val post=binding.editTextTextPersonName15.text.toString()
            val phone=binding.editTextTextPersonName16.text.toString()

            val bill =Bill(name,lastname,address,suburb,town,post,phone)


            if(uid !=null){
                databaseReference.child(uid).setValue(bill).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this@Billing,"Billing Successful ", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, cardDetails::class.java)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this@Billing,"Failed to add billing", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }





    }
}