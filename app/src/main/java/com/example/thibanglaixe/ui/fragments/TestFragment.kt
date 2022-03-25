package com.example.thibanglaixe.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thibanglaixe.R
import com.example.thibanglaixe.adapters.TestAdapters
import com.example.thibanglaixe.databinding.FragmentTestBinding
import com.example.thibanglaixe.model.Test
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject


class TestFragment : Fragment(), TestAdapters.OnItemClickListener {

    private lateinit var binding: FragmentTestBinding
    private lateinit var testAdapter: TestAdapters
    private var listOfTest = mutableListOf<Test>()
    private val db = FirebaseFirestore.getInstance()
    private  val TAG = "_TestFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_test ,
            container,
            false)

        fetchData()

        setUpAdapterTest()


        binding.apply {
            backButtonTestFragment.setOnClickListener {
               popToGPLXFragment()
            }
        }
        return binding.root
    }

    private fun setUpAdapterTest(){
        testAdapter = TestAdapters(listOfTest as ArrayList<Test>, this)
        binding.recyclerViewTest.apply {
            adapter = testAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

    }

    private fun popToGPLXFragment(){
        val action = TestFragmentDirections.actionTestFragmentToGPLXFragment()
        findNavController().navigate(action)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchData(){
        Log.d(TAG, "Fetch data")
        db.collection("exams")
            .get()
            .addOnSuccessListener { documents ->
                Log.d(TAG, documents.documents.toString())
                testAdapter.arrayListOfTest =
                    ArrayList(
                    documents.map {
                        val test = it.toObject(Test::class.java)
                        test.idOfTest = it.id
                        test
                    }
                )
                testAdapter.notifyDataSetChanged()
            }.addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

   /* private fun getListQuestions(examId: String){
        db.collection("exams")
            .document(examId)
            .collection("questions")
            .get()
            .addOnSuccessListener { documents ->

                val questions = documents.map {
                    it.toObject(Question::class.java)
                }
                Log.d(TAG, questions.first().answers.toString())
            }.addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }*/

    @SuppressLint("NotifyDataSetChanged")
    override fun navigateToTestQuestionFragment() {
        val action = TestFragmentDirections.actionTestFragmentToTestOpenFragment()
        findNavController().navigate(action)
        testAdapter.notifyDataSetChanged()
    }

}