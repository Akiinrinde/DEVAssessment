package com.example.devassessment.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devassessment.R
import com.example.devassessment.api.ApiServices
import com.example.devassessment.api.RetrofitClient
import com.example.devassessment.api.responsemodel.UserResponse
import com.example.devassessment.views.fragments.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var userAdapter :UserAdapter
    lateinit var userResponse: List<UserResponse>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var progressBar = view.findViewById<ProgressBar>(R.id.userProgressBar)
        var nothingToSHow = view.findViewById<TextView>(R.id.skill_iq_empty_text)
        recyclerView = view.findViewById(R.id.userRecyclerView)
        userAdapter = UserAdapter(view.context)
        recyclerView.adapter = userAdapter
        layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager

        val apiServices = RetrofitClient.instance
        val call = apiServices.getUserDetails()

        call.enqueue(object :Callback<List<UserResponse>>{
            override fun onResponse(call: Call<List<UserResponse>>, response: Response<List<UserResponse>>) {
                progressBar.visibility =View.GONE
                nothingToSHow.visibility =View.GONE
                userResponse = response.body()!!
                userAdapter.addItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {

                nothingToSHow.visibility =View.VISIBLE

            }

        })

    }
}


