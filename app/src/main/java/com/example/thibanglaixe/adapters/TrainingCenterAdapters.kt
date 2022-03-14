package com.example.thibanglaixe.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.ItemLayoutBinding
import com.example.thibanglaixe.model.TrainingCenters

class TrainingCenterAdapters(var trainingCenters: ArrayList<TrainingCenters>):
    RecyclerView.Adapter<TrainingCenterAdapters.ViewHolder>() {
    class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindView(trainingCenter: TrainingCenters) {
            binding.center = trainingCenter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trainingCenter = trainingCenters[position]
        holder.bindView(trainingCenter)
    }

    override fun getItemCount(): Int {
        return trainingCenters.size
    }
}