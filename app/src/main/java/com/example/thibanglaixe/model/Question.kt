package com.example.thibanglaixe.model

class Question(
    var idQuestion: String = "",
    val contentOfQuestion: String = "",
    val kindOfQuestion: String = "",
    val numberOfQuestion: Int = 0,
    val answers: ArrayList<String> = arrayListOf(),
    val correctAnswer: String = "",
    var stateOfQuestion: Int = 0,
    val title: String = "",
    var answer: String = ""
){
    override fun toString(): String {
        return "$numberOfQuestion"
    }

}