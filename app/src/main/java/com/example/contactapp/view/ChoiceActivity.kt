package com.example.contactapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.contactapp.R

class ChoiceActivity : AppCompatActivity() {
    lateinit var btnList: Button
    lateinit var btngrid: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        btnList = findViewById(R.id.btn_list)
        btngrid = findViewById(R.id.btn_grid)

        btnList.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        })
    }
}