package com.airstrike.stylo.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airstrike.core.authentification.RegisteredUser
import com.airstrike.core.authentification.RegistrationHandler
import com.airstrike.core.authentification.RegistrationListener
import com.airstrike.authentication_email_password.EmailPasswordRegistration
import com.airstrike.authentication_google.GoogleRegistration
import com.airstrike.stylo.AuthenticationActivity
import com.airstrike.stylo.R

class RegistrationFragment : Fragment(), RegistrationListener {

    private  var regHanlders : List<RegistrationHandler> = listOf(EmailPasswordRegistration(),
        GoogleRegistration()
    )
    private lateinit var btnLoginRedirect : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        regHanlders.forEach { handler->
            handler.showUIandHandleRegistration(this,view.findViewById(R.id.font),this)
        }
        btnLoginRedirect = view.findViewById(R.id.sign_in_redirect_btn)
        btnLoginRedirect.setOnClickListener{
            redirectToLogin()
        }
    }
    private fun redirectToLogin() {
        (requireActivity() as AuthenticationActivity).loadFragment(LoginFragment())
    }
    override fun onSuccessfulRegistration(registeredUserData: RegisteredUser) {
        Toast.makeText(context, R.string.succesful_sign_up, Toast.LENGTH_LONG)
            .show()
        Handler(Looper.getMainLooper()).postDelayed({redirectToLogin()},1000)      //redirect to registration fragment, delay is here to give user time to read the toast
    }
    override fun onFailedRegistration(reason: String) {
        Toast.makeText(context, reason,Toast.LENGTH_LONG).show()
    }
}

