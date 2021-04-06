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
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FactsRecyclerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount() = 0
}