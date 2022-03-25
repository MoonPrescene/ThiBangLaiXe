package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentTestOpenBinding


class TestOpenFragment : Fragment() {

    private lateinit var binding: FragmentTestOpenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(
           inflater,
           R.layout.fragment_test_open,
           container,
           false
       )

        binding.apply {
            backButtonTestOpenFragment.setOnClickListener {
                popToTestFragment()
            }
            buttonStart.setOnClickListener {
                navigateToTestQuestionFragment()
            }
        }

        return binding.root
    }

    private fun navigateToTestQuestionFragment() {
        val action = TestOpenFragmentDirections.actionTestOpenFragmentToTestQuestionFragment()
        findNavController().navigate(action)
    }

    private fun popToTestFragment() {
        val action = TestOpenFragmentDirections.actionTestOpenFragmentToTestFragment()
        findNavController().navigate(action)
    }


}