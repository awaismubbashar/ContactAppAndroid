package com.example.contactapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.contactapp.data.AppDBHelper
import com.example.contactapp.model.Contact
import com.example.contactapp.view.addContact.AddContactNavigator

class AddContactViewModel: ViewModel() {

//    val name = ObservableField<String>("")
//    val age = ObservableField<String>("")
//    val phonenumber = ObservableField<String>("")
    lateinit var addContactNavigator : AddContactNavigator
    lateinit var context: Contact
    fun setNavigator(addContactNavigator: AddContactNavigator){
        this.addContactNavigator = addContactNavigator
    }

    fun onClick(){
        addContactNavigator.onSave()
    }

    fun onSave(context: Context, name: String, age: String, phonenumber: String){
        val db = AppDBHelper(context)

        db.addValuesToContactTable(name, age, phonenumber)
    }
}