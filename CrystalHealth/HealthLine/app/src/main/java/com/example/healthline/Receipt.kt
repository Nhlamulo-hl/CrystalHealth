package com.example.healthline


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityReceiptBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Receipt : AppCompatActivity() {
    private lateinit var binding: ActivityReceiptBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var details: CartDetail
    private lateinit var uid : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)






        binding.imageView75.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        binding.button7.setOnClickListener {

            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("Cart")

        if(uid.isNotEmpty()){

            getCartData()
        }

    }

    private fun getCartData() {
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {

                details = snapshot.getValue(CartDetail::class.java)!!
                binding.item.text = "R "+ details.ItemPrice
                binding.quantity.text = details.Quantity

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}