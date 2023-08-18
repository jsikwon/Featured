package com.ebookfrenzy.assignment10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val titles: MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemName.text = titles[i].toString()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemName: TextView = itemView.findViewById(R.id.itemTitle)

    }

    override fun getItemCount(): Int {
        return titles.size;
    }
}
