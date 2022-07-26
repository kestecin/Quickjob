package com.example.quickjob.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickjob.R
import com.example.quickjob.model.PersonModel

class PersonListAdapter(var context: Context,var personModelList:MutableList<PersonModel>):
    RecyclerView.Adapter<PersonListAdapter.MyViewModel>() {
    inner class MyViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userLogin: TextView
        var userNicename: TextView
        var userEmail: TextView
        init {
            userLogin = itemView.findViewById(R.id.userLogin)
            userNicename = itemView.findViewById(R.id.userNicename)
            userEmail = itemView.findViewById(R.id.userEmail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.userLogin.text = personModelList[position].user_login.toString()
        holder.userNicename.text = personModelList[position].user_nicename.toString()
        holder.userEmail.text = personModelList[position].user_email.toString()
    }

    override fun getItemCount(): Int {
        return personModelList.size
    }
}