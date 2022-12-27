package com.example.theswitcher_carlosfaria.models

/**
 * Defines a house division with a switch status
 *
 * @param divisionName Name of the House Division
 * @param switchStatus Status of the light switch
 * **/
class DivisionSwitch(var divisionName: String, var switchStatus: Boolean) {

    /**
     * Switches the status of the division light
     * **/
    fun switch(){
        switchStatus = !switchStatus
    }

}