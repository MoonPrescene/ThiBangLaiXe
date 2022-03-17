package com.example.thibanglaixe.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentInformationBinding


class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_information_,
            container,
            false)

        binding.apply {
            cardViewLogin.setOnClickListener {
                popToLoginFragment()
            }
            facebook.setOnClickListener {
                openUrlFaceBook()
            }
            contactAdvertising.setOnClickListener {
                openUrlAdvertising()
            }
        }

        return binding.root
    }

    private fun openUrlAdvertising() {
            val uri = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
    }

    private fun openUrlFaceBook() {
            val uri = Uri.parse("http://www.facebook.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
    }

    private fun popToLoginFragment() {
        val action =  InformationFragmentDirections.actionInformationFragmentToLoginFragment()
        findNavController().navigate(action)
    }



}