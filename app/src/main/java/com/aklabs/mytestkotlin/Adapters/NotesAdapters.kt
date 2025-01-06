package com.aklabs.mytestkotlin.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aklabs.mytestkotlin.Model.AddNotes
import com.aklabs.mytestkotlin.databinding.ActivityShowAllNotesBinding
import com.aklabs.mytestkotlin.databinding.NotesItemRvBinding

class NotesAdapters(private val notes: List<AddNotes>) :
    RecyclerView.Adapter<NotesAdapters.NoteadapViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteadapViewHolder {
        val binding = NotesItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteadapViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NoteadapViewHolder, position: Int) {
       val note=notes[position]
   holder.bind(note)
    }


    override fun getItemCount(): Int {
       return notes.size
    }

    class NoteadapViewHolder(private val binding: NotesItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: AddNotes) {
  binding.tvshowtitle.text=note.title
  binding.tvshowdescription.text=note.fulldrscriptions
        }

    }
}

