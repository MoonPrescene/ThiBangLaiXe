package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,
            container,
            false)

        binding.apply {
            backButtonLoginFragment.setOnClickListener {
                popToInformationFragment()
            }
        }

        return binding.root
    }

    private fun popToInformationFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToInformationFragment()
        findNavController().navigate(action)
    }


}