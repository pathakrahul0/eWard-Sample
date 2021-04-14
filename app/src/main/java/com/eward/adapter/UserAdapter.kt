package com.eward.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eward.R
import com.eward.databinding.AdapterUserBinding
import com.eward.interfaces.OnItemClicks
import com.eward.model.UserDetails

class UserAdapter(
    private val userList: ArrayList<UserDetails>,
    private val onItemClicks: OnItemClicks,
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.rowBinding.tvUserName.text = user.employeeName
        holder.rowBinding.tvUserEmail.text = "${user.employeeSalary}"

        holder.rowBinding.lUser.setOnClickListener {
            onItemClicks.onItemClick(position)
        }

    }


    override fun getItemCount(): Int {
        return userList.size
    }


    inner class ViewHolder(var rowBinding: AdapterUserBinding) :
        RecyclerView.ViewHolder(rowBinding.root)


}