package com.example.theswitcher_carlosfaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Division Switch Details Activity, with detailed information about the division light status
 * **/
class SwitchDetailsActivity : AppCompatActivity() {

    //Declares Division data variables
    private lateinit var divisionName : String
    private var divisionSwitchStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_details)

        //Sets Activity Action Bar
        setSupportActionBar(findViewById(R.id.detailsToolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        //Customize the Action Bar Back Button, when clicked, Activity finishes
        val backButton = findViewById<LinearLayout>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        //Gets data from the intent
        divisionName = intent.getStringExtra("divisionName").toString()
        divisionSwitchStatus = intent.getBooleanExtra("divisionSwitchStatus", false)

        //Sets Activity toolbar title
        val toolbarTitle = findViewById<TextView>(R.id.detailsToolbarTitle)
        toolbarTitle.text = divisionName

        //Initializes component variables from the layout, in order to change the attributes later
        val imageViewDivisionSwitch = findViewById<ImageView>(R.id.imageViewLight)
        val textViewStatusTitle = findViewById<TextView>(R.id.textViewStatusTitle)
        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)

        setUIDetails(divisionSwitchStatus, imageViewDivisionSwitch, textViewStatus, textViewStatusTitle)
    }

    /**
     * Sets the Activity Layout components information, for the user to see the data
     *
     * @param divisionSwitchStatus Status of the division Switch, true -> ON, false -> OFF
     * @param imageViewDivisionSwitch Image of the division Light
     * @param textViewStatus Status of the Division Light, ON or OFF
     * @param textViewStatusTitle Title with the division light description
     * **/
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