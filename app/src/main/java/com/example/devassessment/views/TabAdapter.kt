package com.example.devassessment.views

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import androidx.fragment.app.FragmentPagerAdapter
import com.example.devassessment.views.fragments.CarsFragment
import com.example.devassessment.views.fragments.UserFragment

class TabAdapter (private val myContext: Context, fm: androidx.fragment.app.FragmentManager, private var tabCount:Int): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        when(position){
            0 -> {
               return CarsFragment()
            }
            1 -> {
                return UserFragment()
            }
        }
        throw IllegalStateException("position $position is invalid for this viewpager")
    }

}