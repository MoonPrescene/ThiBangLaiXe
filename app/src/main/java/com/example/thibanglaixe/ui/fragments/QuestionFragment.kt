package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.thibanglaixe.R
import com.example.thibanglaixe.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_question,
            container,
        false)

        return binding.root
    }


}
