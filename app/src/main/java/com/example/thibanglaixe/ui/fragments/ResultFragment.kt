 package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thibanglaixe.R
import com.example.thibanglaixe.adapters.ResultQuestionAdapter
import com.example.thibanglaixe.databinding.FragmentResultBinding
import com.example.thibanglaixe.model.Question
import com.google.firebase.firestore.FirebaseFirestore

 class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var resultQuestionAdapter: ResultQuestionAdapter
    private var arrayListQuestionResult = arrayListOf<Question>()
     private var arrayListCorrectQuestionResult = arrayListOf<Question>()
     private var arrayListIncorrectQuestionResult = arrayListOf<Question>()
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_result,
            container,
            false)
        getData()
        setUpAdapter(arrayListQuestionResult)
        binding.apply {
            buttonTestAgain.setOnClickListener {
                popToTestOpenFragment()
            }
            backButtonResultQuestionFragment.setOnClickListener {
                popToTestFragment()
            }
            textViewSelectAll.setOnClickListener{
                setUpAdapter(arrayListQuestionResult)
            }
            linearSelectCorrectQuestion.setOnClickListener {
                setUpAdapter(arrayListCorrectQuestionResult)
            }
            linearSelectIncorrectQuestion.setOnClickListener {
                setUpAdapter(arrayListIncorrectQuestionResult)
            }
        }
        return binding.root
    }

     private fun popToTestFragment() {
         val action = ResultFragmentDirections.actionResultFragmentToTestFragment()
         findNavController().navigate(action)
     }

     private fun popToTestOpenFragment() {
         val action = ResultFragmentDirections.actionResultFragmentToTestOpenFragment()
         findNavController().navigate(action)
     }

     private fun setUpAdapter(arrayList: ArrayList<Question>) {
        resultQuestionAdapter = ResultQuestionAdapter(arrayList)
        binding.recyclerViewResultOfQuestion.apply {
            adapter = resultQuestionAdapter
            layoutManager = LinearLayoutManager(context)
        }
     }

     fun getData(){
         db.collection("exams")
             .document("IhwoPilZJpKrA5KlYI3S")
             .collection("questions")
             .get()
             .addOnSuccessListener { documents ->
                 for (document in documents){
                     val question = document.toObject(Question::class.java)
                     if (question.stateOfQuestion == 1){
                         arrayListCorrectQuestionResult.add(question)
                     }
                     if (question.stateOfQuestion == 0){
                         arrayListIncorrectQuestionResult.add(question)
                     }
                     arrayListQuestionResult.add(question)
                 }
             }
     }


 }