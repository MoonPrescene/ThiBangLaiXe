package com.example.thibanglaixe.model

import com.google.common.primitives.UnsignedLong
import com.google.type.DateTime

class Rate (
    val nameOfRater: String,
    val idOfRater: UnsignedLong,
    val contentOfRate: String,
    val dateOfRate: DateTime,
    val valueOfRate: Int
        )