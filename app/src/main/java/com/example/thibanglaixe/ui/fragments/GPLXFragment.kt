package com.example.thibanglaixe.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.thibanglaixe.databinding.FragmentGPLXBinding
import com.example.thibanglaixe.model.Question
import com.example.thibanglaixe.model.Test
import com.google.firebase.firestore.FirebaseFirestore


class GPLXFragment : Fragment() {

    private lateinit var binding: FragmentGPLXBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentGPLXBinding.inflate(inflater, container, false)
        binding.apply {
            cardViewTest.setOnClickListener {
               popToTestFragment()
            }
            cardViewPicture.setOnClickListener {
                popToPictureFragment()
            }
            cardViewTips.setOnClickListener {
                popToTipFragment()
            }
            cardViewHelp.setOnClickListener {
                openUrl()
            }
        }

        return binding.root

    }

    private fun openUrl() {
        val uri = Uri.parse("http://www.google.com")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun popToPictureFragment() {
        val action = GPLXFragmentDirections.actionGPLXFragmentToPictureFragment()
        findNavController().navigate(action)
    }

    private fun popToTestFragment() {
        val action = GPLXFragmentDirections.actionGPLXFragmentToTestFragment()
        findNavController().navigate(action)
    }

    private fun popToTipFragment(){
        val action = GPLXFragmentDirections.actionGPLXFragmentToTipFragment()
        findNavController().navigate(action)
    }

  /*  private fun fetchData(){
        val ref = db.collection("exams").document("IhwoPilZJpKrA5KlYI3S")
        ref.get().addOnSuccessListener { document ->
            if (document != null) {
                Log.d(TAG, "DocumentSnapshot data: ${document.data}")
            } else {
                Log.d(TAG, "No such document")
            }
            listQuestions(document.id)
        }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }

    fun listQuestions(examId: String){
        val documentRef = db.collection("exams")
            .document("IhwoPilZJpKrA5KlYI3S")
            .collection("questions")
            .document("hbnCXhREm03HN33MMZwf")
            .get().addOnSuccessListener { documentSnapshot->
                val question = documentSnapshot.toObject<Question>()
                Log.d(TAG, "DocumentSnapshot data: ${documentSnapshot.data}")
            }
            .addOnFailureListener { exception->
                Log.d(TAG, "get failed with ", exception)
            }
    }
*/

 /*   private fun fetchData(){
        db.collection("exams")
            .get()
            .addOnSuccessListener { document->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.documents}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }*/



}