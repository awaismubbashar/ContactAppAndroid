package com.example.contactapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.R
import com.example.contactapp.adapter.ContactAdapter
import com.example.contactapp.databinding.ActivityContactBinding
import com.example.contactapp.viewmodel.ContactViewModel

class ContactActivity : AppCompatActivity(), ToolbarListener {

    lateinit var binding: ActivityContactBinding
    lateinit var mviewmodel: ContactViewModel
    lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_contact)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact)
        setContentView(binding.root)
        mviewmodel = ViewModelProvider(this).get(ContactViewModel::class.java)
        binding.viewmodel = mviewmodel
        adapter = ContactAdapter()
        binding.contactRecyclerview.adapter = adapter
        mviewmodel.toolbarListener=this

    }

    override fun onAddClick() {
        Log.d("TAG", "onAddClick: ")
    }
}