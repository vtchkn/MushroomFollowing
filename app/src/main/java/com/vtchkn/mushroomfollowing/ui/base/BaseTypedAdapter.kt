package com.vtchkn.mushroomfollowing.ui.base

import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseTypedAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private var items: MutableList<T> = ArrayList()

    fun addAllAndNotify(items: MutableList<T>) {
        this.items = items
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position), position)
    }

    fun getItem(position: Int): T {
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
