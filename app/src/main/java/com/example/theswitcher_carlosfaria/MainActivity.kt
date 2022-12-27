package com.example.theswitcher_carlosfaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theswitcher_carlosfaria.adapters.SwitchAdapter
import com.example.theswitcher_carlosfaria.models.DivisionSwitch

class MainActivity : AppCompatActivity() {

    private lateinit var switchList : RecyclerView
    private var divisionList : ArrayList<DivisionSwitch> = arrayListOf()

    lateinit var divisionNames : Array<String>
    lateinit var divisionSwitches : Array<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets the custom Action Bar
        setSupportActionBar(findViewById(R.id.switcherToolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        divisionNames = arrayOf("Kitchen", "Living room", "Master bedroom", "Guest's Bedroom")
        divisionSwitches = arrayOf(false, false, false, false)

        switchList = findViewById(R.id.homeSwitchesList)
        switchList.layoutManager = LinearLayoutManager(this)
        switchList.setHasFixedSize(true)

        initializeData()

        switchList.adapter = SwitchAdapter(divisionList)
    }

    private fun initializeData(){
        for(i in divisionNames.indices){
            val division = DivisionSwitch(divisionNames[i], divisionSwitches[i])
            divisionList.add(division)
        }
    }
}