package com.vtchkn.mushroomfollowing.ui.base


import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(private val baseContainerView: BaseContainerView<T>) : RecyclerView.ViewHolder(baseContainerView) {

    fun bind(item: T, position: Int) {
        baseContainerView.bind(item)
    }

}
