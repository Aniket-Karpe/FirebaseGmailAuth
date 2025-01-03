package com.aklabs.mytestkotlin.Model

data class AddNotes(val title:String,val fulldrscriptions:String) {
    constructor():this(" "," ")
}