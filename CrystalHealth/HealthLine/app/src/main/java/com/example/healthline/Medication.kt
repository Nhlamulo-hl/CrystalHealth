package com.example.healthline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthline.databinding.ActivityMedicationBinding

class Medication : AppCompatActivity() {


    private lateinit var binding: ActivityMedicationBinding
    private lateinit var MediArrayList: ArrayList<Medii>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView85.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }



        val imageId = intArrayOf(

            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k
        )


        val name = arrayOf(

            "Corenza C 20's",
            "Progast Colon Cleanse 10 Tablets",
            "Ferrous Forte 60 capsules",
            "Amoxicillin 500mg",
            "Allergex Tablets 4mg",
            "Sinutab Sinus Severe Pain 20 Tablets",
            "Sinutab Sinus Head Cold Day 20 Tablets",
            "Canex'V Vag Cream 50g",
            "Ibuprofen Nurofen Tablets 200mg",
            "Voltaren 20g gel",
            "Biocort 20g cream"
        )
        val description = arrayOf(


            "R151.00",

            "R 87.99",
            "R 250.00",
            "R300",
            "R 85.99",
            "R76.99",
            "R 73.95",
            "R 34.95",
            "R 70.99",

            "R 63.95",
            "R 26.95"

            )
        val messages = arrayOf(

            "Respiratory 1and2 Cough, Cold And Flu Corenza-C 500mg Eff Tablets 10",

            "Progast Gastrointestinal Support Oxy-Colon Cleanse 10 Capsules",

            "Ferrous Forte Complete Iron Supplement 60 Tablets helps maintain healthy red blood cells which plays" +
                    " a role in oxygen transport." +
                    " This supplement contains a combination of Amino Acid Chelated Iron, folic acid, vitamin B12 and C.",
            " used to treat bacterial infections, such as chest infections (including pneumonia)" +
                    " and dental abscesses. It can also be used together with other antibiotics and medicines to treat stomach ulcers. " +
                    "It's often prescribed for children, to treat ear infections and chest infections.",

            ": Treatment of symptoms of seasonal allergic rhinitis such as runny nose, itchy nose, sneezing, " +
                    "itchy or red throat, itchy eyes and watery eyes; " +
                    "Treatment of chronic idiopathic urticaria, urticaria with choline or idiopathic cold urticaria.",

            "Temporarily relieves nasal and sinus congestion, sinus pressure, sinus pain, headache, runny nose," +
                    " sneezing, itching of the nose or throat, itchy, watery eyes and minor aches and pains due to the common cold, " +
                    "flu, hay fever (allergic rhinitis), sinusitis and other respiratory allergies.",


            "Temporarily relieves nasal and sinus congestion, sinus pressure, sinus pain, headache, runny nose, " +
                    "sneezing, itching of the nose or throat, itchy, watery eyes and minor aches and pains due to the common cold, " +
                    "flu, hay fever (allergic rhinitis), sinusitis and other respiratory allergies.",

            " For the treatment of vaginal yeast infections. Ascendis.",
            "Relieves: headaches, tension headaches, migraines, back pain, muscular and rheumatic pain, body aches and pain, " +
                    "inflammation, dental pain, period pain, cold and flu symptoms, fever ",

            "Voltaren Emulgel is used to treat pain and inflammation of muscles, joints, tendons and ligaments, " +
                    "due to sprains and strains, sports injuries eg. tennis elbow and soft tissue rheumatism" +
                    " eg. bursitis, tendinitis. Voltaren Emulgel contains the non steroidal anti inflammatory drug NSAID," +
                    " diclofenac. Diclofenac works to relieve pain and reduce inflammation swelling.",

            "Deflazacort is used in the treatment of Inflammatory conditions, Autoimmune conditions and cancer.",


        )

        MediArrayList = ArrayList()

        for (i in name.indices) {

            val birdss = Medii(name[i], description[i], messages[i], imageId[i])
            MediArrayList.add(birdss)
        }
        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, MediArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val messages = messages[position]
            val imageId = imageId[position]

            val i = Intent(this, MedicationView::class.java)
            i.putExtra("name", name)
            i.putExtra("message", messages)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }

}
