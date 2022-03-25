package com.example.thibanglaixe.model


class Test {
    var idOfTest: String = ""
    val nameOfTest: String = ""
    val numberOfQuestion: Int = 0
    val stateOfTest: Int = 0
    val questionOfTest = mutableListOf<Question>()
    var numberOfCorrectQuestion: Int = 0
    var numberOfIncorrectQuestion: Int = 0
    override fun toString(): String {
        return if (stateOfTest == 0) "Passed"
        else {
            "Failed"
        }
    }

    fun numberOfCorrectAnswerToString(): String{
        return "${numberOfCorrectQuestion}"
    }

    fun numberOfIncorrectAnswerToString(): String{
        return "${numberOfIncorrectQuestion}"
    }
}