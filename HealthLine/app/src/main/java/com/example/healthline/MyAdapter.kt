package com.example.healthline

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (private val context: Activity, private val arrayList : ArrayList<Medii>) : ArrayAdapter<Medii>(context,
    R.layout.medi,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.medi,null)
        val imageView : ImageView = view.findViewById(R.id.pictures)
        val username : TextView = view.findViewById(R.id.Name)
        val lastMsg : TextView = view.findViewById(R.id.Description)


        imageView.setImageResource(arrayList[position].imageID)
        username.text = arrayList[position].name
        lastMsg.text = arrayList[position].description



        return view
    }

}
