package com.aklabs.mytestkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.aklabs.mytestkotlin.databinding.ActivityMainBinding
import com.aklabs.mytestkotlin.databinding.ActivitySignoutBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignoutActivity : AppCompatActivity() {

    private lateinit var bindingsignout:ActivitySignoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingsignout=ActivitySignoutBinding.inflate(layoutInflater)
        setContentView(bindingsignout.root)

        toucheventsignout()
    }

    private fun toucheventsignout() {
        bindingsignout.btnsignout.setOnClickListener{
            val gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_client_id)).requestEmail().build()
           GoogleSignIn.getClient(this,gso).signOut()
            startActivity(Intent(this,MainActivity::class.java))

        }
    }
}