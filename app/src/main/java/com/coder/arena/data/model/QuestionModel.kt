package com.coder.arena.data.model

import java.util.Date

data class QuestionModel(
    val id: String,
    val name: String,
    val dateOfBirth: Date,
    val phoneNumber: String,
    val country: String,
    val age: Int
)