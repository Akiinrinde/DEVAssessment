package com.example.devassessment.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devassessment.R
import com.example.devassessment.views.fragments.adapter.CarsAdapter
import com.opencsv.CSVReaderHeaderAware
import java.io.FileReader


class CarsFragment : Fragment() {



    lateinit var carRecyclerView: RecyclerView
    lateinit var carAdapter :CarsAdapter
    lateinit var layoutManager:LinearLayoutManager



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cars, container,false)


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        showData()
        logResult()


    }


    private fun logResult(){
        val reader = CSVReaderHeaderAware(FileReader("raw/car_ownsers_data.csv"))
        val resultList = mutableListOf<Map<String, String>>()
        var line = reader.readMap()

        while(line != null ){
            resultList.add(line)
            line = reader.readMap()
        }
        Log.d("result1", resultList[1].toString())

    }

    private fun showData(){
        carRecyclerView = view?.findViewById(R.id.car_recyclerView)!!
        carAdapter = CarsAdapter(view?.context)
        carRecyclerView.adapter= carAdapter
        layoutManager = LinearLayoutManager(view?.context)
        carRecyclerView.layoutManager = layoutManager

    }

}