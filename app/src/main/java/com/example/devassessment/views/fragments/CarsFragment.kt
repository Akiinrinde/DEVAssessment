package com.example.devassessment.views.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devassessment.R
import com.example.devassessment.views.fragments.adapter.CarsAdapter


class CarsFragment : Fragment() {
    lateinit var carRecyclerView: RecyclerView
    lateinit var carAdapter :CarsAdapter
    lateinit var layoutManager:LinearLayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cars, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carRecyclerView = view.findViewById(R.id.car_recyclerView)
        carAdapter =  CarsAdapter(view.context)
        carRecyclerView.adapter= carAdapter
        layoutManager = LinearLayoutManager(view.context)
        carRecyclerView.layoutManager = layoutManager

    }
}