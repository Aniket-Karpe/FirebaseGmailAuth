package com.aklabs.mytestkotlin


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.activity.result.contract.ActivityResultContracts
import com.aklabs.mytestkotlin.databinding.ActivityMainBinding
import com.aklabs.mytestkotlin.databinding.UserSignupBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingusersignup: UserSignupBinding
    private lateinit var googleSigninclient:GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_client_id)).requestEmail().build()
        auth= Firebase.auth
        googleSigninclient= GoogleSignIn.getClient(this,gso)
        touchevent()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun touchevent() {
     binding.btnsubmitauth.setOnClickListener{
         auth.createUserWithEmailAndPassword(binding.emaildata.text.toString(),
             binding.passwordfilled.text.toString())
             .addOnCompleteListener(this) { task ->
                 if (task.isSuccessful) {
                   Toast.makeText(this,"Successful Logged IN",Toast.LENGTH_LONG).show()
                     startActivity(Intent(this,AddNewNotes::class.java))
                 } else {

                     Toast.makeText(this,"Failed to login",Toast.LENGTH_LONG).show()
                 }
             }
     }

        binding.googlesignin.setOnClickListener {
   val signInClient=googleSigninclient.signInIntent
      launcher.launch(signInClient)

        }



        binding.btnsinup.setOnClickListener{
            showSignUpLayout()

        }
    }

    private fun showSignUpLayout() {
        bindingusersignup= UserSignupBinding.inflate(layoutInflater)
        setContentView(bindingusersignup.root)

    }

    private val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
result->
    if(result.resultCode==Activity.RESULT_OK)
    {
        val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)

        if(task.isSuccessful)
        {
            val account:GoogleSignInAccount?=task.result
            val credentials=GoogleAuthProvider.getCredential(account?.idToken,null)
            auth.signInWithCredential(credentials).addOnCompleteListener {
                if(it.isSuccessful)
                {
                    startActivity(Intent(this,AddNewNotes::class.java))
                    Toast.makeText(this,"SuccessFul to Login",Toast.LENGTH_LONG).show()
                }
                else{

                    Toast.makeText(this,"Failed to login",Toast.LENGTH_LONG).show()
                }
            }
        }


    }else{

        Toast.makeText(this,"Failed to login",Toast.LENGTH_LONG).show()
    }
}


}