package com.example.thibanglaixe.model

class TrainingCenters(
    val logoOfCenter: Int,
    val nameOfCenter: String,
    val descriptionOfCenter: String,
    val addressOfCenter: Address,
    val rateOfCenter: MutableList<Rate>?
)