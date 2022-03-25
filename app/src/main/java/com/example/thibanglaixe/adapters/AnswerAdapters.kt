package com.example.thibanglaixe.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.ListItemAnswerBinding
import com.example.thibanglaixe.model.Question
import com.google.firebase.firestore.FirebaseFirestore

class AnswerAdapters(
    var listOfAnswer: ArrayList<String>,
    var answerSelected: String = "",
    var question: Question,
    var onItemButtonClickListener: OnItemButtonClickListener
): RecyclerView.Adapter<AnswerAdapters.ViewHolder>() {

    val db = FirebaseFirestore.getInstance()

    inner class ViewHolder(
        var binding: ListItemAnswerBinding,
        val onItemButtonClickListener: OnItemButtonClickListener
    ):RecyclerView.ViewHolder(binding.root){
        fun bindView(answer: String, question: Question) {
            binding.apply {
                checkboxAnswer.text = answer
                checkboxAnswer.isChecked = question.answer == answer
            }
            binding.root.setOnClickListener {
                Log.d("_AnswerAdapters", "Tap to answer")
                Log.d("_AnswerAdapters", "id: ${question.idQuestion}")
                onItemButtonClickListener.onItemClick(answer, question)
                checkCorrectAnswer()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemAnswerBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_item_answer,
            parent,
            false
        )

        return ViewHolder(binding, onItemButtonClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val answer = listOfAnswer[position]
        return holder.bindView(answer, question)
    }

    override fun getItemCount(): Int {
        return listOfAnswer.size
    }


    fun checkCorrectAnswer(){
        if(question.answer == question.correctAnswer){
            question.stateOfQuestion = 1
        }else{
            question.stateOfQuestion = 0
        }
        setStateOfQuestion(question.idQuestion)
    }

    private fun setStateOfQuestion(questionId: String){
        db.collection("exams")
            .document("IhwoPilZJpKrA5KlYI3S")
            .collection("questions")
            .document(questionId)
            .update("stateOfQuestion", question.stateOfQuestion)
            .addOnSuccessListener {
                Log.d("UpdateStateOfQuestion", "UpDate Successfully!!!")
            }.addOnFailureListener {
                Log.d("UpdateStateOfQuestion", "UpDate Fail!!!")
            }

    }

    interface OnItemButtonClickListener{
        fun onItemClick(answer: String, question: Question)
    }
}