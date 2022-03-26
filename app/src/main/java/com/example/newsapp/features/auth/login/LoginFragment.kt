package com.example.newsapp.features.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.fragment.findNavController
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.data.repo.user.UserRepositoryImp.Companion.getUserRepository
import com.example.newsapp.databinding.FragmentLoginBinding
import com.example.newsapp.features.auth.AuthModelFactory
import com.example.newsapp.features.auth.AuthViewModel

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    lateinit var loginBtn: Button
    lateinit var userNameEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var gotoRegisterTxt: TextView

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

        viewModel = ViewModelProvider(
            this, AuthModelFactory(
                getUserRepository(app = requireActivity().application)
            )
        ).get(AuthViewModel::class.java)


        gotoRegisterTxt.setOnClickListener {
            findNavController().navigate(ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)) //for test purposal only
        }

        loginBtn.setOnClickListener {
            //check if there are strings or not
            if (userNameEdt.text.toString().trim().isNullOrEmpty() || passwordEdt.text.toString()
                    .trim().isNullOrEmpty()
            ) {
                Toast.makeText(context, getString(R.string.try_again), Toast.LENGTH_LONG).show()
                loginBtn.visibility = View.VISIBLE
            } else
                viewModel.getUserByEmail(email = userNameEdt.text.toString().trim())
                    ?.observe(this@LoginFragment.viewLifecycleOwner, androidx.lifecycle.Observer
                    {
                        if (it != null) {

                            if (it.isNullOrEmpty()) {
                                Toast.makeText(
                                    context,
                                    getString(R.string.try_again),
                                    Toast.LENGTH_LONG
                                ).show()
                                loginBtn.visibility = View.VISIBLE
                            } else {
                                if (it[0].password == passwordEdt.text.toString()) {
                                    //here password = list password so let him in the app
                                    var intent = Intent(context, NewsActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        context,
                                        getString(R.string.wrong_password),
                                        Toast.LENGTH_LONG
                                    ).show()
                                    loginBtn.visibility = View.VISIBLE

                                }

                            }
                        } else {
                            Toast.makeText(
                                context,
                                getString(R.string.try_again),
                                Toast.LENGTH_LONG
                            ).show()
                            loginBtn.visibility = View.VISIBLE
                        }


                    })
        }


        return root
    }

}