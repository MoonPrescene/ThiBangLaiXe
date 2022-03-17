package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
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
import com.example.thibanglaixe.model.Question
import com.example.thibanglaixe.model.Test
import com.google.firebase.firestore.FirebaseFirestore


class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private lateinit var testAdapter: TestAdapters


    val question = Question("Hom nay la thu may", "cau hoi de",
    "Thu 2",
    "thu 2",
    "hom nay la thu 2",
    )


    val listOfQuestion = mutableListOf<Question>(
        question,
        question,
        question,
        question
    )

    private val testList = arrayListOf<Test>(
        Test("Test 1", 25, null, 1, listOfQuestion),
        Test("Test 2", 25, null, 1, listOfQuestion),
        Test("Test 3", 25, null, 1, listOfQuestion),
        Test("Test 4", 25, null, 1, listOfQuestion),
        Test("Test 5", 25, null, 1, listOfQuestion)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_test ,
            container,
            false)
        setUpAdapterTest()

        binding.apply {
            backButtonTestFragment.setOnClickListener {
               popToGPLXFragment()
            }
        }
        return binding.root
    }

    private fun setUpAdapterTest(){
        testAdapter = TestAdapters(testList)
        binding.recyclerViewTest.apply {
            adapter = testAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    private fun popToGPLXFragment(){
        val action = TestFragmentDirections.actionTestFragmentToGPLXFragment()
        findNavController().navigate(action)
    }

    fun readFireStore(){
        val db = FirebaseFirestore.getInstance()
        db.collection("exam").document(
                "hbnCXhREm03HN33MMZwf")
            .get()
            .addOnCompleteListener { documentSnapshot->
                    val question = documentSnapshot.result
                }

    }

}