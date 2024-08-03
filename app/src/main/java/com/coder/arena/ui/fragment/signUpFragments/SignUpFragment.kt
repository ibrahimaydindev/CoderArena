package com.coder.arena.ui.fragment.signUpFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.ViewFlipper
import com.coder.arena.R
import com.coder.arena.data.enum.AccountTypeEnum
import com.coder.arena.data.enum.AccountWorkspaceEnum
import com.coder.arena.data.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Locale


class SignUpFragment : Fragment() {

    private lateinit var viewFlipper: ViewFlipper
    private lateinit var newUser:UserModel
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    private val accountTypeLlIndex:Int = 0
    private val accountWorkspaceLlIndex:Int = 1
    private val userCreate1LlIndex:Int = 2
    private val userCreate2LlIndex:Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        firestore =FirebaseFirestore.getInstance()
        newUser = UserModel()
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
            newUser.accountType = AccountTypeEnum.Personal.getName()
            showIndex(accountWorkspaceLlIndex)
        }

        teacherButton.setOnClickListener {
            newUser.accountType = AccountTypeEnum.Teacher.getName()
            showIndex(accountWorkspaceLlIndex)

        }

        studentButton.setOnClickListener {
            newUser.accountType = AccountTypeEnum.Student.getName()
            showIndex(accountWorkspaceLlIndex)

        }

        professionalButton.setOnClickListener {
            newUser.accountType = AccountTypeEnum.Professional.getName()
            showIndex(accountWorkspaceLlIndex)

        }

        skipAccountTypeButton.setOnClickListener {
            newUser.accountType = AccountTypeEnum.NoEntry.getName()
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
            newUser.accountWorkspace = AccountWorkspaceEnum.School.getName()
            showIndex(userCreate1LlIndex)
        }

        highEduButton.setOnClickListener {
            newUser.accountWorkspace = AccountWorkspaceEnum.HighEdu.getName()
            showIndex(userCreate1LlIndex)
        }

        teamsButton.setOnClickListener {
            newUser.accountWorkspace = AccountWorkspaceEnum.Teams.getName()
            showIndex(userCreate1LlIndex)
        }

        businessButton.setOnClickListener {
            newUser.accountWorkspace = AccountWorkspaceEnum.Business.getName()
            showIndex(userCreate1LlIndex)
        }

        skipAccountWorkspaceButton.setOnClickListener {
            newUser.accountWorkspace = AccountWorkspaceEnum.NoEntry.getName()
            showIndex(userCreate1LlIndex)
        }

        accountWorkspaceBackButton.setOnClickListener {
            showIndex(accountTypeLlIndex)
        }

    }

    private fun initUserCreateFirstLayout(view: View) {

        val nameEditText = view.findViewById<EditText>(R.id.full_name)
        val birthDate = view.findViewById<EditText>(R.id.birth_date)
        val phoneEditText = view.findViewById<EditText>(R.id.editTextPhone)
        val countrySpinner = view.findViewById<Spinner>(R.id.country_spinner)

        val userCreate1ContinueButton = view.findViewById<View>(R.id.user_create_1_continue_button)
        val userCreate1BackButton = view.findViewById<View>(R.id.user_create_1_back_button)

        val countries = listOf("USA", "Canada", "UK", "Australia","Turkey")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.adapter = adapter

        userCreate1ContinueButton.setOnClickListener {

            if (nameEditText.text.toString().isEmpty())
                return@setOnClickListener

            if (birthDate.text.toString().isEmpty())
                return@setOnClickListener

            if (phoneEditText.text.toString().isEmpty())
                return@setOnClickListener

            newUser.name = nameEditText.text.toString()
            newUser.birthDate = dateFormat.parse(birthDate.text.toString())!!
            newUser.phoneNumber = phoneEditText.text.toString()
            newUser.country = countrySpinner.selectedItem.toString()

            showIndex(userCreate2LlIndex)
        }

        userCreate1BackButton.setOnClickListener {
            showIndex(accountWorkspaceLlIndex)
        }
    }

    private fun initUserCreateSecLayout(view: View) {

        val userName = view.findViewById<EditText>(R.id.user_name)
        val eMail = view.findViewById<EditText>(R.id.e_mail)
        val password = view.findViewById<EditText>(R.id.password)

        val userCreate1ContinueButton = view.findViewById<View>(R.id.sign_up_button)
        val userCreate2BackButton = view.findViewById<View>(R.id.user_create_2_back_button)

        userCreate1ContinueButton.setOnClickListener {

            if (userName.text.toString().isEmpty())
                return@setOnClickListener

            if (eMail.text.toString().isEmpty())
                return@setOnClickListener

            if (password.text.toString().isEmpty())
                return@setOnClickListener

            newUser.userName = userName.text.toString()
            newUser.eMail = eMail.text.toString()
            newUser.password = password.text.toString()

            Log.i("Create User","newUser : " + newUser.toString())

            createUser(newUser.eMail, newUser.password)
        }

        userCreate2BackButton.setOnClickListener {
            showIndex(userCreate1LlIndex)
        }
    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        newUser.id = user.uid
                    }
                    Log.i("Create User", "User created and authenticated: ${user?.email}")
                    addUserToFirestore(newUser.id)
                } else {
                    Log.e("Create User", "User creation failed", task.exception)
                }
            }
    }


    private fun addUserToFirestore(userId: String?) {
        if (userId != null) {
            // `newUser` nesnesini Firestore'da `users` koleksiyonuna ekleyin
            firestore.collection("users").document(userId).set(newUser)
                .addOnSuccessListener {
                    Log.i("Create User", "User successfully added to Firestore")
                    // Kullanıcıyı yönlendirme veya diğer işlemleri gerçekleştirebilirsiniz
                }
                .addOnFailureListener { e ->
                    Log.e("Create User", "Error adding user to Firestore", e)
                }
        } else {
            Log.e("Create User", "User ID is null, cannot add user to Firestore")
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