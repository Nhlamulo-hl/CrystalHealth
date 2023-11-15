package com.example.healthline

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityCartBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Cart : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var  auth: FirebaseAuth
    private lateinit var  databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Cart")

        binding.imageView74.setOnClickListener {
            val intent = Intent(this, cardDetails::class.java)
            startActivity(intent)
        }

        binding.button9.setOnClickListener {
            val itemNo = binding.itemPriceEditText.text.toString()
            val quantity=binding.quantityEditText.text.toString()


            val cat =CartDetail(itemNo,quantity)


            if(uid !=null){
                databaseReference.child(uid).setValue(cat).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this@Cart,"Billing Successful ", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Receipt::class.java)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this@Cart,"Failed to add billing", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }





    }
}