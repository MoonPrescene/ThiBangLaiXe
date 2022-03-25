package com.example.thibanglaixe.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentQuestionBinding
import com.example.thibanglaixe.model.Question

class QuestionAdapter(
    var listOfQuestion: ArrayList<Question>,
    ) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: FragmentQuestionBinding)
        : RecyclerView.ViewHolder(binding.root), AnswerAdapters.OnItemButtonClickListener{
        private lateinit var answerAdapter: AnswerAdapters
            fun bindView(question: Question) {
                answerAdapter = AnswerAdapters(question.answers,
                    question.answer, question, this)
                binding.apply {
                    questions = question
                }
                binding.answerRecyclerView.apply {
                    adapter = answerAdapter
                    layoutManager = LinearLayoutManager(binding.root.context)
                }
            }



        @SuppressLint("NotifyDataSetChanged")
        override fun onItemClick(answer: String, question: Question) {
            question.answer = answer
            answerAdapter.answerSelected = answer
            answerAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: FragmentQuestionBinding = inflate(
            inflater,
            R.layout.fragment_question,
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = listOfQuestion[position]
        holder.bindingAdapterPosition
        return holder.bindView(question)
    }

    override fun getItemCount(): Int {
        return listOfQuestion.size
    }


    interface OnQuestionClickListener{

    }

}