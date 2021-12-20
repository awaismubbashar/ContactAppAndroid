package com.example.contactapp.viewmodel

import androidx.databinding.ObservableField
import com.example.contactapp.model.Contact

class ContactItemViewModel(contact: Contact) {
    var name = ObservableField<String>("")
    var age = ObservableField<String>("")
    var phoneNumber = ObservableField<String>("")

    init {
        name.set(contact.name)
        age.set(contact.age.toString())
        phoneNumber.set(contact.phoneNumber)
    }
}