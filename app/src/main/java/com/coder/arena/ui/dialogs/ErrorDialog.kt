package com.coder.arena.ui.dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coder.arena.R

class ErrorDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_dialog)
    }
}