package com.example.happyplaces.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.happyplaces.models.HappyPlaceModel
import com.example.happyplaces.databinding.ItemHappyPlaceBinding

class HappyPlacesAdapter(private var list: ArrayList<HappyPlaceModel>) : RecyclerView.Adapter<HappyPlacesAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemHappyPlaceBinding) : RecyclerView.ViewHolder(binding.root){
        val imageView = binding.ivPlaceImage
        val title = binding.tvTitle
        val description = binding.tvDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemHappyPlaceBinding.inflate(
                LayoutInflater.from(parent.context) ,parent, false
            ))
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {

        val model = list[position]
        if (holder is ViewHolder) {
            holder.imageView.setImageURI(Uri.parse(model.image))
            holder.title.text = model.title
            holder.description.text = model.description
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}