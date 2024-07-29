package com.coder.arena.ui.fragment.signUpFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ViewFlipper
import com.coder.arena.R


class SignUpFragment : Fragment() {

    private var viewFlipper: ViewFlipper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        viewFlipper = view.findViewById(R.id.create_account_flipper);

        val skipButton = view.findViewById<View>(R.id.skip_button)
        skipButton.setOnClickListener {
            showNext()
        }
        val backButton = view.findViewById<View>(R.id.back_button)
        backButton.setOnClickListener {
            showPrevious()
        }


        return view
    }

    private fun showNext() {
        viewFlipper?.showNext()
    }

    private fun showPrevious() {
        viewFlipper?.showPrevious()
    }

}