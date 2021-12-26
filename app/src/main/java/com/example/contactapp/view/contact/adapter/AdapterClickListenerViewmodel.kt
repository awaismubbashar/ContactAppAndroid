package com.example.contactapp.view.contact.adapter

import androidx.databinding.ObservableField
import com.example.contactapp.model.Contact

class AdapterClickListenerViewmodel(contact: Contact)  {

    var name = ObservableField<String>("")
    var age = ObservableField<String>("")
    var phoneNumber = ObservableField<String>("")
    lateinit var itemClickListener: ItemClickListener

    init {
        name.set(contact.name)
        age.set(contact.age.toString())
        phoneNumber.set(contact.phoneNumber)
    }

    fun onClick(){
        itemClickListener.onClick()
    }

    @JvmName("setItemClickListener1")
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }
}