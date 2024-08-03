package com.coder.arena.data.model

import android.media.Image
import java.util.Date

data class UserModel(
    var id: String = "",
    var name: String = "",
    var userName: String = "",
    var password: String = "",
    var accountType: String = "",
    var accountWorkspace: String = "",
    var birthDate: Date = Date(),
    var eMail: String = "",
    var phoneNumber: String = "",
    var country: String = "",
    var age: Int = 0,
    var level: Int = 0,
    var isPremium: Boolean = false

    )
