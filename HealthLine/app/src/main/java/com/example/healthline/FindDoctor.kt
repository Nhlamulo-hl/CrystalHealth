package com.example.healthline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityFindDoctorBinding


class FindDoctor : AppCompatActivity() {

    private lateinit var binding: ActivityFindDoctorBinding
    private lateinit var DocArrayList: ArrayList<Doc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView30.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
    }





        val imageId = intArrayOf(

            R.drawable.v, R.drawable.w, R.drawable.t, R.drawable.u, R.drawable.z
        )


        val name = arrayOf(

            "Dr.Schalk Van Stader",
            "Dr.Nicolene Cillers",
            "Dr.Ayanda Motau",
            "Dr.Kevin Ho",
            "Dr.Tendani Muthambi"

        )
        val description = arrayOf(


            "General Practitioner",

            "General Practitioner",
            "Dermatologist",
            "Cardiologist",
            "Surgeon"


        )

        DocArrayList = ArrayList()

        for (i in name.indices) {

            val doctor= Doc(name[i], description[i], imageId[i])
            DocArrayList.add(doctor)
        }
        binding.listview.isClickable = true
        binding.listview.adapter = Adapter(this, DocArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]

            val imageId = imageId[position]

            val i = Intent(this, Appointment::class.java)
            i.putExtra("name", name)

            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }

    }
