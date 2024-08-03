package com.coder.arena.data.enum

enum class  AccountWorkspaceEnum(val type: Int) {
    NoEntry(0),
    School(1),
    HighEdu(2),
    Teams(3),
    Business(4);

    fun getName(): String {
        return when (this) {
            NoEntry -> "NoEntry"
            School -> "School"
            HighEdu -> "HighEdu"
            Teams -> "Teams"
            Business -> "Business"
        }
    }
}

