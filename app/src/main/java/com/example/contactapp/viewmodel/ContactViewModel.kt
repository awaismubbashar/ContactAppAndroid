package com.example.contactapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.contactapp.model.Contact
import com.example.contactapp.view.ToolbarListener

class ContactViewModel: ViewModel() {

    val contactList = ObservableField<ArrayList<Contact>>()
    lateinit var toolbarListener: ToolbarListener

    init {
        var list = ArrayList<Contact>()
        list.add(Contact("name", 5, "38294"))
        list.add(Contact("Awais", 5, "4564"))
        list.add(Contact("alis", 5, "454"))
        list.add(Contact("name", 5, "38294"))

        contactList.set(list)
    }
}