package com.example.contactapp.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.adapter.ContactAdapter;
import com.example.contactapp.model.Contact;

import java.util.ArrayList;

public final class BindingUtils {

    @BindingAdapter("setContentView")
    public static void setContentView(RecyclerView recyclerView, ArrayList<Contact> contactArrayList){
        ContactAdapter contactAdapter = (ContactAdapter) recyclerView.getAdapter();
        if (contactAdapter != null && contactArrayList != null) {
            contactAdapter.setContactsList(contactArrayList);
        }
    }
}
