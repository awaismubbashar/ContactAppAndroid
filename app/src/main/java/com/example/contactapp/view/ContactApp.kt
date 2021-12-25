package com.example.contactapp.view

import android.content.Context

class ContactApp {

    lateinit var instance: Context

    fun getContext(): Context? {
        return this.getContext()
    }

    fun isNullOrEmpty(string: String?): Boolean {
        return string == null || string.equals("null", ignoreCase = true) || string.equals(
            "",
            ignoreCase = true
        )
    }

}