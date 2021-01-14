package com.example.devassessment.views.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devassessment.R



class CarsAdapter(private val context: Context?) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cars_item,parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 65500
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}