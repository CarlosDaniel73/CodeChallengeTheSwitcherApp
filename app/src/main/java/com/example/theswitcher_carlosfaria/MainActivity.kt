package com.example.theswitcher_carlosfaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theswitcher_carlosfaria.adapters.SwitchAdapter
import com.example.theswitcher_carlosfaria.models.DivisionSwitch

/**
 * Switch App Launch Activity with list of divisions
 * **/
class MainActivity : AppCompatActivity() {

    //Define Recycler View Variable
    private lateinit var switchList : RecyclerView

    //Local Test Division variables, holding division information like name and switch status
    private var divisionList : ArrayList<DivisionSwitch> = arrayListOf()
    lateinit var divisionNames : Array<String>
    lateinit var divisionSwitches : Array<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets the custom Action Bar
        setSupportActionBar(findViewById(R.id.switcherToolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        //Initializes array of values for division name and division switch status
        divisionNames = arrayOf("Kitchen", "Living room", "Master bedroom", "Guest's Bedroom")
        divisionSwitches = arrayOf(false, false, false, false)

        //Configures Recycler View
        switchList = findViewById(R.id.homeSwitchesList)
        switchList.layoutManager = LinearLayoutManager(this)
        switchList.setHasFixedSize(true)

        //Adds a divider to the Recycler View, so that each item is visually divided with a grey line
        val dividerDecoration = DividerItemDecoration(this,
            LinearLayoutManager(this).orientation)
        switchList.addItemDecoration(dividerDecoration)

        initializeData()

        //Sets adapter for the recycler view
        switchList.adapter = SwitchAdapter(divisionList, this)
    }

    /**
     * Initializes [divisionList] variable with all the test divisions data
     * **/
    private fun initializeData(){
        for(i in divisionNames.indices){
            val division = DivisionSwitch(divisionNames[i], divisionSwitches[i])
            divisionList.add(division)
        }
    }
}