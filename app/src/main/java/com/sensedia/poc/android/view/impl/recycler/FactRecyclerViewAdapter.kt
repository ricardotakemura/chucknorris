package com.sensedia.poc.android.view.impl.recycler

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sensedia.poc.android.R
import com.sensedia.poc.android.model.bean.Fact
import com.squareup.picasso.Picasso

class FactRecyclerViewAdapter(var facts: List<Fact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class FactsRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun setData(fact: Fact) {
            val imageView = itemView.findViewById<ImageView>(R.id.factImageView)
            Picasso.get()
                .load(fact.icon_url)
                .resize(89,89).into(imageView)
            val textView = itemView.findViewById<TextView>(R.id.factTextView)
            textView.text = fact.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main, null)
        return FactsRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val factsHolder = holder as FactsRecyclerViewHolder
        factsHolder.setData(facts[position])
    }

    override fun getItemCount() = facts.size
}