package com.example.thibanglaixe.ui.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.thibanglaixe.R
import com.example.thibanglaixe.adapters.QuestionAdapter
import com.example.thibanglaixe.adapters.TestAdapters
import com.example.thibanglaixe.adapters.TestQuestionAdapters
import com.example.thibanglaixe.databinding.FragmentTestQuestionBinding
import com.example.thibanglaixe.model.Question
import com.google.firebase.firestore.FirebaseFirestore


class TestQuestionFragment : Fragment(),
    TestQuestionAdapters.OnNumberOfQuestionClickListener,
    QuestionAdapter.OnQuestionClickListener {

    private lateinit var binding: FragmentTestQuestionBinding
    private lateinit var testQuestionAdapters: TestQuestionAdapters
    private lateinit var questionAdapter: QuestionAdapter
    private val db = FirebaseFirestore.getInstance()
    private val arrayListOfQuestion = arrayListOf<Question>()
    private var  currentQuestionPosition = 0



    private val snapHelper: SnapHelper = LinearSnapHelper()
    private var listAnswer = arrayListOf<String>(
        "Answer 1", "Answer 2", "Answer 3"
    )
    private var questionList = listOf<Question>(
        Question(
            contentOfQuestion = "aaa",
            answers = listAnswer
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_test_question,
            container,
            false
        )
        //initView()

        setUpAdapterTop()
        setUpAdapterBottom()
        binding.apply {
            backButtonTestQuestionFragment.setOnClickListener {
                popToTestFragment()
            }

            buttonBackQuestion.setOnClickListener {
                scrollToBackItem()
            }

            buttonNextQuestion.setOnClickListener {
                scrollToNextItem()
            }
            buttonSubmit.setOnClickListener {
                openDialogAlert()
            }
        }

        return binding.root
    }

    private fun openDialogAlert() {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Do you want to submit?")
        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
            navigateToResultFragment()
        })
        builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })
        builder.show()
    }

    private fun navigateToResultFragment() {
        val action = TestQuestionFragmentDirections.actionTestQuestionFragmentToResultFragment()
        findNavController().navigate(action)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun scrollToNextItem() {
        if (currentQuestionPosition > questionAdapter.listOfQuestion.size){
            return
        }

        currentQuestionPosition += 1
        binding.recyclerViewQuestion.scrollToPosition(currentQuestionPosition)

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun scrollToBackItem() {
        if( currentQuestionPosition < 1) {
            return
        }

        currentQuestionPosition -= 1
        binding.recyclerViewQuestion.scrollToPosition(currentQuestionPosition)
    }


    private fun setUpAdapterBottom() {
        questionAdapter = QuestionAdapter(ArrayList(questionList))
        binding.recyclerViewQuestion.apply {
            adapter = questionAdapter
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,
                false)
        }
        snapHelper.attachToRecyclerView(binding.recyclerViewQuestion)
    }


    private fun popToTestFragment() {
        val action = TestQuestionFragmentDirections.actionTestQuestionFragmentToTestFragment()
        findNavController().navigate(action)
    }


    private fun setUpAdapterTop() {
        testQuestionAdapters = TestQuestionAdapters(arrayListOfQuestion,
            this)
        binding.recyclerViewNumberOfQuestion.apply {
            adapter = testQuestionAdapters
            layoutManager = GridLayoutManager(context, 15)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    val docRef = db.collection("exams")
        .document("IhwoPilZJpKrA5KlYI3S")
        .collection("questions")
        .get()
        .addOnSuccessListener { documents ->

            testQuestionAdapters.arrayListQuestion = ArrayList(
                documents.map {
                    val question = it.toObject(Question::class.java)
                    question.idQuestion = it.id
                    question
                }
            )

            questionAdapter.listOfQuestion = ArrayList(
                documents.map {
                    val question = it.toObject(Question::class.java)
                    question.idQuestion = it.id
                    question
                }
            )



            testQuestionAdapters.notifyDataSetChanged()
            questionAdapter.notifyDataSetChanged()
        }

    @SuppressLint("NotifyDataSetChanged")
    override fun scrollToSelectedItem(index: Int) {
        val answers = questionAdapter.listOfQuestion.map {
            it.answer + "NO_ANSWER"
        }
        Log.d("_QUESTION", answers.toString())
        currentQuestionPosition = index
        Toast.makeText(requireContext(), "click $index", Toast.LENGTH_LONG).show()
        binding.recyclerViewQuestion.scrollToPosition(index)
        questionAdapter.notifyDataSetChanged()
    }



}