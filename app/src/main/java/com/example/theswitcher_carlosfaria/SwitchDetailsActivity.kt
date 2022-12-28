package com.example.theswitcher_carlosfaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SwitchDetailsActivity : AppCompatActivity() {

    private lateinit var divisionName : String
    private var divisionSwitchStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_details)

        divisionName = intent.getStringExtra("divisionName").toString()
        divisionSwitchStatus = intent.getBooleanExtra("divisionSwitchStatus", false)

        val imageViewDivisionSwitch = findViewById<ImageView>(R.id.imageViewLight)
        val textViewStatusTitle = findViewById<TextView>(R.id.textViewStatusTitle)
        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)

        setUIDetails(divisionSwitchStatus, imageViewDivisionSwitch, textViewStatus, textViewStatusTitle)
    }

    private fun setUIDetails(divisionSwitchStatus : Boolean, imageViewDivisionSwitch: ImageView,
                             textViewStatus : TextView, textViewStatusTitle : TextView){
        if(divisionSwitchStatus){
            imageViewDivisionSwitch.setImageResource(R.drawable.img)
            textViewStatus.setText(R.string.switch_on)
        }else{
            imageViewDivisionSwitch.setImageResource(R.drawable.light_off)
            textViewStatus.setText(R.string.switch_off)
        }

        val title = String.format(resources.getString(R.string.switch_details_title), divisionName)
        textViewStatusTitle.text = title
    }
}