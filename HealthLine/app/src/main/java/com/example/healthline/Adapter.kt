package com.example.healthline

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter (private val context: Activity, private val arrayList : ArrayList<Doc>) : ArrayAdapter<Doc>(context,
    R.layout.docc,arrayList) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.docc, null)
        val imageView: ImageView = view.findViewById(R.id.pictures)
        val username: TextView = view.findViewById(R.id.Name)
        val lastMsg: TextView = view.findViewById(R.id.Description)


        imageView.setImageResource(arrayList[position].imageId)
        username.text = arrayList[position].name
        lastMsg.text = arrayList[position].description



        return view
    }}