package com.example.newsapp.features.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.fragment.findNavController
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.data.repo.user.UserRepositoryImp
import com.example.newsapp.data.source.local.LocalSource
import com.example.newsapp.data.source.local.NewsDatabase
import com.example.newsapp.data.source.local.UserDao
import com.example.newsapp.databinding.FragmentLoginBinding
import com.example.newsapp.features.auth.AuthModelFactory
import com.example.newsapp.features.auth.AuthViewModel
import com.example.newsapp.utils.SharedPreferenceUtil

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    lateinit var loginBtn: Button
    lateinit var userNameEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var gotoRegisterTxt: TextView
    lateinit var rememberMeCheckBox: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        userNameEdt = binding.loginEditUserName
        passwordEdt = binding.loginEditPassword
        loginBtn = binding.loginButtonLogin
        gotoRegisterTxt = binding.loginTextCreateNewAccount
        rememberMeCheckBox=binding.loginCheckerTextRememberMe

        viewModel = ViewModelProvider(
            this, AuthModelFactory(
                UserRepositoryImp(LocalSource( NewsDatabase.getInstance(requireContext()).userDao()))
            )
        ).get(AuthViewModel::class.java)

        gotoRegisterTxt.setOnClickListener {
            findNavController().navigate(ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)) //for test purposal only
        }

        loginBtn.setOnClickListener {
            loginBtn.visibility = View.INVISIBLE
            //check if there are strings or not
            if (userNameEdt.text.toString().trim().isNullOrEmpty() || passwordEdt.text.toString()
                    .trim().isNullOrEmpty()
            ) {
                tryAgain(getString(R.string.try_again))
            } else
                viewModel.getUserByEmail(email = userNameEdt.text.toString().trim())
                    ?.observe(this@LoginFragment.viewLifecycleOwner, androidx.lifecycle.Observer
                    {
                        if (it != null) {

                            if (it.isNullOrEmpty()) {
                              tryAgain(getString(R.string.try_again))
                            } else {
                                if (it[0].password == passwordEdt.text.toString()) {
                                    //here password = list password so let him in the app
                                    val intent = Intent(context, NewsActivity::class.java)
                                   if(rememberMeCheckBox.isChecked){
                                       SharedPreferenceUtil.setUserLoggedIn(requireContext())
                                   }
                                    startActivity(intent)
                                } else {
                                   tryAgain( getString(R.string.wrong_password))
                                }
                            }
                        } else {
                            tryAgain(getString(R.string.try_again))
                        }

                    })
        }


        return root
    }

    private fun tryAgain(message:String) {
        Toast.makeText(context,message , Toast.LENGTH_LONG).show()
        loginBtn.visibility = View.VISIBLE
    }

}