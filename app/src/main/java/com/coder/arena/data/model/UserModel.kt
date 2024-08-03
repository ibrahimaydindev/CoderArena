package com.coder.arena.data.model

import android.media.Image
import java.util.Date

data class UserModel(
    val id: String,
    val name: String,
    val userName: String,
    val password:String,
    val accountType:String,
    val accountWorkspace:String,
    val eMail: String,
    val phoneNumber: String,
    val country: String,
    var age: Int,
    val level : Int,
    val isPremium : Boolean,

)
