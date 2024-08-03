package com.coder.arena.data.enum

enum class  AccountTypeEnum(val type: Int) {
    NoEntry(0),
    Personal(1),
    Teacher(2),
    Student(3),
    Professional(4);

    fun getName(): String {
        return when (this) {
            NoEntry -> "NoEntry"
            Personal -> "Personal"
            Teacher -> "Teacher"
            Student -> "Student"
            Professional -> "Professional"
        }
    }
}

