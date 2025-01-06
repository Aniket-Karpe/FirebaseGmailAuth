package com.aklabs.mytestkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aklabs.mytestkotlin.Adapters.NotesAdapters
import com.aklabs.mytestkotlin.Model.AddNotes
import com.aklabs.mytestkotlin.databinding.ActivityAddNewNotesBinding
import com.aklabs.mytestkotlin.databinding.ActivityShowAllNotesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowAllNotes : AppCompatActivity() {

    private val binding: ActivityShowAllNotesBinding by lazy {
        ActivityShowAllNotesBinding.inflate(layoutInflater)
    }
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        recyclerView=binding.recyclerView
        databaseReference = FirebaseDatabase.getInstance().getReference("Notes")
        auth=FirebaseAuth.getInstance()
        val currentuser=auth.currentUser
        currentuser?.let  {
                user->
            // val notekey=databaseRefrence.child("users").child(user.uid).child("notes").push().key
            val notekeyrefrence=databaseReference.child("users").child(user.uid).child("notes")
            notekeyrefrence.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val noteslist= mutableListOf<AddNotes>()
                    for (notessnapshot in snapshot.children){
                        val note=notessnapshot.getValue(AddNotes::class.java)
                         note?.let { noteslist.add(it) }
                    }
                    val adapter=NotesAdapters(noteslist)
                    recyclerView.adapter=adapter
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })

        }


    }
}