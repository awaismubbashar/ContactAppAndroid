package com.example.contactapp.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import com.example.contactapp.databinding.ActivityContactBinding
import com.example.contactapp.model.Contact
import android.view.LayoutInflater
import com.example.contactapp.databinding.ItemContactBinding
import com.example.contactapp.viewmodel.ContactItemViewModel

//import android.view.View

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    var contactsList = ArrayList<Contact>()

    inner class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int){
            binding.viewmodel = ContactItemViewModel(contactsList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_contact, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

}