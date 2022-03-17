package com.example.thibanglaixe.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridLayout
import android.widget.GridView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.ItemTestLayoutBinding
import com.example.thibanglaixe.model.Test

class TestAdapters(var arrayListOfTest: ArrayList<Test>): RecyclerView.Adapter<TestAdapters.ViewHolder>(){
    class ViewHolder(val binding: ItemTestLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(tests: Test){
            binding.test = tests
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemTestLayoutBinding = inflate(
            inflater,
            R.layout.item_test_layout,
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val test = arrayListOfTest[position]
        holder.bindView(test)
    }

    override fun getItemCount(): Int {
        return arrayListOfTest.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}