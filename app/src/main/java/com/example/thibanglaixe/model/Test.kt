package com.example.thibanglaixe.model


import com.google.type.DateTime

class Test (
    val nameOfTest: String,
    val numberOfQuestion: Int,
    val timeOfTest: DateTime?,
    val stateOfTest: Int,
    val questionOfTest: MutableList<Question>,
   // var numberOfCorrectQuestion: Int,
   // var numberOfWrongQuestion: Int
        )