package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.databinding.ItemLayoutBinding
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model.ItemsData

class ItemListAdapter(private val onItemClick: (itemsData:  List<ItemsData>, key: Int) -> Unit, private var items: Map<String, List<ItemsData>>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemsData: List<ItemsData>, key: String) {
            binding.keyTextView.text = key
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val key = items.keys.elementAt(position)
        holder.bind(items[key]!!,key)
        holder.itemView.setOnClickListener {
            onItemClick(items[key]!!,position)

        }
    }

    override fun getItemCount(): Int = items.size

    fun setData(itemsS: Map<String, List<ItemsData>>) {
        if (itemsS != null) {
            items = itemsS
        }
        notifyDataSetChanged()

    }
}

