
package com.example.healthline

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityAppointmentBinding

class Appointment : AppCompatActivity() {
    private lateinit var binding: ActivityAppointmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button11.setOnClickListener {
            val intent = Intent(this, PatientConfirmation::class.java)
            startActivity(intent)
        }

    }


}

