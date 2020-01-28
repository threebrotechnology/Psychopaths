package com.lifeindarkness.psychopaths

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ItemsAdapter(
    private var items: List<String>,
    context: Context,
    private var onItemClick: (index: Int) -> Unit
) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem = view.tvItem!!
        val cardView = view.cardView!!
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardView.setOnClickListener {
            onItemClick(position)
        }
        val item = items[position]
        holder.tvItem.text = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }
}