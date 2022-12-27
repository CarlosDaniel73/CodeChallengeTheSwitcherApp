package com.example.theswitcher_carlosfaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets the custom Action Bar
        setSupportActionBar(findViewById(R.id.switcherToolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
}