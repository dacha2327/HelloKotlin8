package com.dacha.hellokotlin8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dacha.hellokotlin8.databinding.ItemListBinding

class CarAdapter(private var data: ArrayList<Car> , private val onClick:(pos:Int)-> Unit):
RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }

    override fun getItemCount() = data.size

    inner class CarViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(car: Car){
            binding.name.text = car.name
            binding.description.text = car.description
            Glide.with(binding.image).load(car.image).into(binding.image)


        }

    }
}