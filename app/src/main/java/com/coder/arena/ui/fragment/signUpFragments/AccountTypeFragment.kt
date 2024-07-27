package com.coder.arena.ui.fragment.signUpFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.coder.arena.R


class AccountTypeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account_type, container, false)

        val skipButton = view.findViewById<View>(R.id.skip_button)
        skipButton.setOnClickListener {
            navigateNextFragment()
        }

        return view
    }
    private fun navigateNextFragment() {
        val fragment = AccountDetailsFragment()
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_account_type_container, fragment)
        transaction.addToBackStack(null) // onBackPressed
        transaction.commit()
    }

}