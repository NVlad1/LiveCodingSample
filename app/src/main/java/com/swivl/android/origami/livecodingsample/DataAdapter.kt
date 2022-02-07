package com.swivl.android.origami.livecodingsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val data: List<String>, val checked: MutableList<Boolean>): RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DataViewHolder(layoutInflater, parent){
            if (it == null) return@DataViewHolder
            checked[it] = !checked[it]
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(position, data[position], checked[position])
    }
}