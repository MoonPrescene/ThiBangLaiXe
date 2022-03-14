package com.example.thibanglaixe.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thibanglaixe.R
import com.example.thibanglaixe.adapters.TrainingCenterAdapters
import com.example.thibanglaixe.databinding.FragmentTrainingBinding
import com.example.thibanglaixe.model.TrainingCenters

class Training_Fragment : Fragment() {

    private lateinit var binding: FragmentTrainingBinding

    private lateinit var trainingCenterAdapters: TrainingCenterAdapters

    private var trainingCenterList = arrayListOf<TrainingCenters>(
        TrainingCenters(R.drawable.common_google_signin_btn_icon_dark_normal_background,"Trung tâm dạy nghề lái xe Chiến Thắng",
            "Trung tâm hiện tại đang đào tạo các hạng lái xe máy A1, A2; xe ô tô B1",
            "0939188019","https://chienthangcantho.com",
            "Thành Phố Cần Thơ")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapters()
    }

    private fun setUpAdapters() {
        trainingCenterAdapters = TrainingCenterAdapters(trainingCenterList)
        binding.recyclerViewTrainingCenters.apply {
            adapter = trainingCenterAdapters
            layoutManager = LinearLayoutManager(context)
        }
    }

}