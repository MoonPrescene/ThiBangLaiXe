package com.example.thibanglaixe.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.ItemResultQuestionBinding
import com.example.thibanglaixe.model.Question

class ResultQuestionAdapter(
    var arraylistResultQuestion: ArrayList<Question>
): RecyclerView.Adapter<ResultQuestionAdapter.ViewHolder>(){
    class ViewHolder(
        val binding: ItemResultQuestionBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bindView(question: Question) {
            binding.question = question
            binding.apply {
                if (question.stateOfQuestion == 1){
                    imageViewOfQuestionResult.setImageResource(R.drawable.correct)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemResultQuestionBinding = inflate(
            inflater,
            R.layout.item_result_question,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = arraylistResultQuestion[position]
        return holder.bindView(question)
    }

    override fun getItemCount(): Int {
        return arraylistResultQuestion.size
    }


}