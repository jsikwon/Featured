package com.ebookfrenzy.assignment8

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data = Data()


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        val randomNumber = (0..7).random()

        viewHolder.itemTitle.text = data.titles[randomNumber]
        viewHolder.itemDetail.text = data.details[randomNumber]
        viewHolder.itemImage.setImageResource(data.images[randomNumber])
    }

    override fun getItemCount(): Int {
        return data.titles.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

}