package com.coder.arena.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coder.arena.R
import com.coder.arena.ui.fragment.signUpFragments.SignUpFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = FirebaseAuth.getInstance();

        checkUserSession()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun checkUserSession() {
        val currentUser = auth.currentUser
        if (currentUser != null) {

            loadUserData(currentUser)

        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_account_type_container, SignUpFragment())
                .commit()
        }
    }

    private fun loadUserData(user: FirebaseUser) {

        openMainActivity ()

        }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        }

    }