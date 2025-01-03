package com.aklabs.mytestkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.aklabs.mytestkotlin.Model.AddNotes
import com.aklabs.mytestkotlin.databinding.ActivityAddNewNotesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNewNotes : AppCompatActivity() {

    private val bindingaddnote:ActivityAddNewNotesBinding by lazy {
        ActivityAddNewNotesBinding.inflate(layoutInflater)
    }
    private lateinit var databaseRefrence:DatabaseReference
    private lateinit var auth:FirebaseAuth
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingaddnote.root)
        databaseRefrence=FirebaseDatabase.getInstance().getReference("Notes")
        auth=FirebaseAuth.getInstance()
        bindingaddnote.btnsavenotes.setOnClickListener {
            val title=bindingaddnote.etaddtitle.text.toString()
            val descriptions=bindingaddnote.etfulldescription.text.toString()
            if(title.isEmpty()&& descriptions.isEmpty())
            {
                Toast.makeText(this,"Please Filled the All required Data",Toast.LENGTH_LONG).show()
            }
            else{
             val currentuser=auth.currentUser
                currentuser?. let{
                    user->
                   // val notekey=databaseRefrence.child("users").child(user.uid).child("notes").push().key
                    val notekey=databaseRefrence.child("users").child(user.uid).child("notes").push().key
                    val noteItems=AddNotes(title, descriptions)
                    Log.d("Items","checkItemsValues: $title, : $descriptions")
                    if (notekey!=null)

                    databaseRefrence.child("users").child(user.uid).child("notes").
                    child(notekey).setValue(noteItems).addOnCompleteListener{

                        task -> if(task.isSuccessful){
                        Toast.makeText(this,"Notes Saved Succesful",Toast.LENGTH_LONG).show()
//                        finish()
                    }
                        else {  Toast.makeText(this,"failed to save Notes",Toast.LENGTH_LONG).show()
                        Log.d("UserRef","summer $notekey")}
                    }
                }
            }
        }
    }
}