package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thibanglaixe.databinding.FragmentGPLXBinding


class GPLX_Fragment : Fragment() {

    private lateinit var binding: FragmentGPLXBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.apply {

        }

        // Inflate the layout for this fragment
        binding = FragmentGPLXBinding.inflate(inflater, container, false)
        return binding.root

    }


}