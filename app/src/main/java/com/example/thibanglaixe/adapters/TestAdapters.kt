package com.example.thibanglaixe.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.ItemTestLayoutBinding
import com.example.thibanglaixe.model.Question
import com.example.thibanglaixe.model.Test
import com.google.firebase.firestore.FirebaseFirestore

class TestAdapters(var arrayListOfTest: ArrayList<Test>,
                   val onItemClickListener: OnItemClickListener)
    : RecyclerView.Adapter<TestAdapters.ViewHolder>(){

    val db = FirebaseFirestore.getInstance()
    var listCorrectQuestion = arrayListOf<Question>()
    var listIncorrectQuestion = arrayListOf<Question>()

    inner class ViewHolder(val binding: ItemTestLayoutBinding,
                    val onItemClickListener: OnItemClickListener
                     ): RecyclerView.ViewHolder(binding.root){
        fun bindView(tests: Test){
            getData(tests.idOfTest)
            tests.numberOfCorrectQuestion = listCorrectQuestion.size
            tests.numberOfIncorrectQuestion = listIncorrectQuestion.size
            binding.test = tests
            binding.apply {
                cardViewOpenTest.setOnClickListener {
                    onItemClickListener.navigateToTestQuestionFragment()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemTestLayoutBinding = inflate(
            inflater,
            R.layout.item_test_layout,
            parent,
            false)
        return ViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val test = arrayListOfTest[position]
        holder.bindView(test)
    }

    override fun getItemCount(): Int {
        return arrayListOfTest.size
    }

    fun getData(idTest: String){
        db.collection("exams")
            .document(idTest)
            .collection("questions")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents){
                    val question = document.toObject(Question::class.java)
                    if (question.stateOfQuestion == 1){
                        listCorrectQuestion.add(question)
                    }else{
                        listIncorrectQuestion.add(question)
                    }
                }
            }
        }

    interface OnItemClickListener{
        fun navigateToTestQuestionFragment()
    }
}