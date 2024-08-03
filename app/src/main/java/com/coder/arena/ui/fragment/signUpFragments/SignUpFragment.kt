package com.coder.arena.ui.fragment.signUpFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ViewFlipper
import com.coder.arena.R


class SignUpFragment : Fragment() {

    private lateinit var viewFlipper: ViewFlipper

    private val accountTypeLlIndex:Int = 0
    private val accountWorkspaceLlIndex:Int = 1
    private val userCreate1LlIndex:Int = 2
    private val userCreate2LlIndex:Int = 3

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


        initAccountTypeLayout(view)
        initAccountWorkspaceLayout(view)
        initUserCreateFirstLayout(view)
        initUserCreateSecLayout(view)


        return view
    }




    private fun initAccountTypeLayout(view: View) {

        val personalButton = view.findViewById<View>(R.id.personal_layout)
        val teacherButton = view.findViewById<View>(R.id.teacher_layout)
        val studentButton = view.findViewById<View>(R.id.student_layout)
        val professionalButton = view.findViewById<View>(R.id.professional_layout)
        val skipAccountTypeButton = view.findViewById<View>(R.id.skip_account_type_button)

        personalButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)
        }

        teacherButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)

        }

        studentButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)

        }

        professionalButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)

        }

        skipAccountTypeButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)
        }
    }

    private fun initAccountWorkspaceLayout(view: View) {

        val schoolButton = view.findViewById<View>(R.id.school_layout)
        val highEduButton = view.findViewById<View>(R.id.high_edu_layout)
        val teamsButton = view.findViewById<View>(R.id.teams_layout)
        val businessButton = view.findViewById<View>(R.id.business_layout)
        val skipAccountWorkspaceButton = view.findViewById<View>(R.id.skip_acoount_workspace_button)
        val accountWorkspaceBackButton = view.findViewById<View>(R.id.back_button_account_workspace)


        schoolButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }

        highEduButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }

        teamsButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }

        businessButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }

        skipAccountWorkspaceButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }

        accountWorkspaceBackButton.setOnClickListener {
            showIndex(accountTypeLlIndex)
        }

    }

    private fun initUserCreateFirstLayout(view: View) {

        val userCreate1ContinueButton = view.findViewById<View>(R.id.user_create_1_continue_button)
        val userCreate1BackButton = view.findViewById<View>(R.id.user_create_1_back_button)

        userCreate1ContinueButton.setOnClickListener {
            Log.i("initUserCreateFirstLayout", "userCreate1ContinueButton")
            showIndex(userCreate2LlIndex)
        }

        userCreate1BackButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)
        }
    }

    private fun initUserCreateSecLayout(view: View) {
        val userCreate1ContinueButton = view.findViewById<View>(R.id.sign_up_button)
        val userCreate2BackButton = view.findViewById<View>(R.id.user_create_2_back_button)

        userCreate1ContinueButton.setOnClickListener {
            //createUser
        }

        userCreate2BackButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }
    }

    private fun showIndex(index : Int) {

        val currentChild = viewFlipper.displayedChild

        if (index > currentChild) {
            viewFlipper.setInAnimation(context, R.anim.slide_in_right)
            viewFlipper.setOutAnimation(context, R.anim.slide_out_left)
        } else if (index < currentChild) {
            viewFlipper.setInAnimation(context, android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(context, android.R.anim.slide_out_right)
        }

        viewFlipper.displayedChild = index

    }
}