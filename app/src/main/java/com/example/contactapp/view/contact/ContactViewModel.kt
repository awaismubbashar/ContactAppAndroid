package com.example.contactapp.view.contact

import android.annotation.SuppressLint
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.contactapp.data.AppDBHelper
import com.example.contactapp.model.Contact
import com.example.contactapp.view.ToolbarListener

class ContactViewModel: ViewModel() {

    val contactList = ObservableField<ArrayList<Contact>>()
    lateinit var toolbarListener: ToolbarListener

    @SuppressLint("Range")
    fun getDataFromCursor(context: Context) {
        val db = AppDBHelper(context)
        val cursor = db.getContactFromDB()
        val list = ArrayList<Contact>()

        if (cursor != null){
            while(cursor.moveToNext()) {
                val contactName = cursor.getString(cursor.getColumnIndex("name"))
                val contactage = cursor.getString(cursor.getColumnIndex("age"))
                val contactPhonenumber = cursor.getString(cursor.getColumnIndex("phoneNumber"))

                if (!(contactName.isNullOrEmpty() && contactage.isNullOrEmpty() && contactPhonenumber.isNullOrEmpty())) {
                    val contact = Contact(contactName, contactage.toInt(), contactPhonenumber)
                    list.add(contact)
                }
            }
            contactList.set(list)
        }

        // at last we close our cursor
        cursor?.close()
    }
}