package com.swivl.android.origami.livecodingsample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DataViewHolder(inflater: LayoutInflater, parent: ViewGroup, val onClick: (Int?) -> Unit) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_data, parent, false)) {

    private val text_title: TextView = itemView.findViewById(R.id.text_title)
    private val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)
    private var position: Int? = null

    fun bind(position: Int, str: String, isChecked: Boolean){
        this.position = position
        text_title.text = str
        checkbox.isChecked = isChecked
        itemView.setOnClickListener {
            checkbox.isChecked = !checkbox.isChecked
            onClick.invoke(position)
        }
    }

}