package com.example.contactapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.R
import com.example.contactapp.databinding.ActivityAddContactBinding
import com.example.contactapp.viewmodel.AddContactViewModel

class AddContact : AppCompatActivity(), AddContactNavigator {

    lateinit var binding: ActivityAddContactBinding
    lateinit var mviewmodel: AddContactViewModel
    lateinit var name: String
    lateinit var age: String
    lateinit var phonenumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_contact)
        setContentView(binding.root)
        mviewmodel = ViewModelProvider(this).get(AddContactViewModel::class.java)
        binding.viewmodel = mviewmodel

        mviewmodel.setNavigator(this)

    }

    override fun onSave() {
        name = binding.addName.text.toString()
        age = binding.addAge.text.toString()
        phonenumber = binding.addNumber.text.toString()


        if (!(name.isNullOrEmpty() || age.isNullOrEmpty() || phonenumber.isNullOrEmpty())) {
            mviewmodel.onSave(this, name, age, phonenumber)
            clearTextFromField()
        }
        else{
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    fun clearTextFromField(){
        binding.addName.text.clear()
        binding.addAge.text.clear()
        binding.addNumber.text.clear()

//        startActivity(Intent(this, ContactActivity::class.java))
    }

}