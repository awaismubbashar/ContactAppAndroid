package com.example.contactapp.view.contact.adapter

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import com.example.contactapp.model.Contact
import android.view.LayoutInflater
import com.example.contactapp.databinding.ItemContactBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    var contactsList = ArrayList<Contact>()
    lateinit var mviewModel: AdapterClickListenerViewmodel
    lateinit var listener: ItemListener

    inner class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root), ItemClickListener {

        fun onBind(position: Int){
            mviewModel = AdapterClickListenerViewmodel(contactsList[position])
            mviewModel.setItemClickListener(this)
            binding.viewmodel = mviewModel
        }

        override fun onClick() {
            listener.onClickListener()
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

    @JvmName("setListener1")
    fun setListener(listener: ItemListener) {
        this.listener = listener
    }

}