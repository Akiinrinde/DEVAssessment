package com.example.devassessment.views.fragments.adapter

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.devassessment.R
import com.example.devassessment.api.responsemodel.UserResponse
import com.example.devassessment.views.fragments.GlideApp

class UserAdapter(private val context:Context ): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var items = ArrayList<UserResponse>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item,parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(list:List<UserResponse>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear(){
        this.items.clear()
        notifyDataSetChanged()
    }



    class UserViewHolder( itemView: View): RecyclerView.ViewHolder(itemView) {
        private  var fullName : TextView = itemView.findViewById(R.id.fullName)
        private  var avi : ImageView = itemView.findViewById(R.id.avi)
        private  var gender: TextView = itemView.findViewById(R.id.gender)
        private  var createdAt : TextView = itemView.findViewById(R.id.created_at)

        fun bind(item:UserResponse){
            fullName.text = item.fullName
            gender.text = item.gender
            createdAt.text = item.createdAt

            Log.d("aviURL", "${item.aviUrl}")
            GlideApp.with(itemView.context).load(item.aviUrl).into(avi)

//            Glide.with(itemView.context).asBitmap().load(item.aviUrl).centerCrop()
//                .into(object : BitmapImageViewTarget(avi){
//                    override fun setResource(resource: Bitmap?) {
//                        avi.setImageBitmap(resource)
//                        super.setResource(resource)
//                    }
//                })
        }


    }
}