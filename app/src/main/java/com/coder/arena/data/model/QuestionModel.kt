package com.coder.arena.data.model

import android.media.Image
data class QuestionModel(
    val questionId: String,
    val questionCreatorId : String,
    val questionText : String,
    val questionImage : Image,
    val questionTime : Int,
    val options : ArrayList<QuestionOption>
)