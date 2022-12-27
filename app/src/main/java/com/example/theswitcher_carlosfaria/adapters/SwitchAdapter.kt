package com.example.theswitcher_carlosfaria.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.theswitcher_carlosfaria.R
import com.example.theswitcher_carlosfaria.models.DivisionSwitch

class SwitchAdapter (private val divisionList: ArrayList<DivisionSwitch>) :
    RecyclerView.Adapter<SwitchAdapter.SwitchViewHolder>() {

    /**
     * View Holder for the [SwitchAdapter] Recycler View Adapter
     * **/
    class SwitchViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val divisionName : TextView = itemView.findViewById(R.id.textViewDivision)
        val switchStatus : SwitchCompat = itemView.findViewById(R.id.divisionSwitch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwitchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.switcher_list_item,
        parent, false)

        return SwitchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SwitchViewHolder, position: Int) {

        val currentItem = divisionList[position]
        holder.divisionName.text = currentItem.divisionName
        holder.switchStatus.isChecked = currentItem.switchStatus

    }

    override fun getItemCount(): Int {
        //Returns the size of the provided division list
        return divisionList.size
    }

}