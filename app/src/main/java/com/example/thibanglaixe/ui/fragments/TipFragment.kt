package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentTipBinding


class TipFragment : Fragment() {

    private lateinit var binding: FragmentTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_tip,
            container,
            false)

        binding.apply {
            backButtonTipFragment.setOnClickListener {
                popToGPLXFragment()
            }
        }

        return binding.root
    }

    private fun popToGPLXFragment() {
        val action = TipFragmentDirections.actionTipFragmentToGPLXFragment()
        findNavController().navigate(action)
    }

}