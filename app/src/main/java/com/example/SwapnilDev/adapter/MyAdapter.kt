package com.example.SwapnilDev.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.SwapnilDev.data.Person
import com.example.SwapnilDev.databinding.RowBinding


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var oldData = emptyList<Person>()

   inner class MyViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.ageTextView.text = oldData[position].age.toString()
        holder.binding.firstNameTextView.text = oldData[position].firstname
        holder.binding.lastNameTextView.text = oldData[position].lastname
    }

    override fun getItemCount(): Int {
        return oldData.size
    }

    fun setData(newData: List<Person>){
        oldData = newData
        notifyDataSetChanged()
    }

}