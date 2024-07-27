package com.coder.arena.data.model

import android.media.Image
import java.util.Date

data class UserModel(
    val id: String,
    val name: String,
    val isPremium : Boolean,
    val level : Int,
    val eMail: String,
    val phoneNumber: String,
    val country: String,
    var age: Int
)
