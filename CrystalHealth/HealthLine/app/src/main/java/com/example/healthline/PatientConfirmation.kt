package com.example.healthline

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityPatientConfirmationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class PatientConfirmation : AppCompatActivity() {

    private lateinit var binding:ActivityPatientConfirmationBinding
    private lateinit var  auth: FirebaseAuth
    private lateinit var  databaseReference: DatabaseReference
    private lateinit var tvDatePicker: TextView
    private lateinit var  btnDatePicker: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        tvDatePicker = findViewById(R.id.txt_booking_time_text)
        btnDatePicker = findViewById(R.id.btn_date)


        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->

            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)


        }

        btnDatePicker.setOnClickListener{

            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Confirm")

        binding.btnConfirm.setOnClickListener {

            val date = binding.txtBookingTimeText.text.toString()
            val name = binding.editTextTextPersonName6.text.toString()
            val appoint=binding.editTextTextPersonName17.text.toString()
            val number=binding.editTextTextPersonName18.text.toString()

val user =PatientConfirm(date,name,appoint,number)


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

    private fun updateLabel(myCalendar: Calendar) {

        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.US)
        tvDatePicker.setText(sdf.format(myCalendar.time))

    }
}