package com.vtchkn.mushroomfollowing.ui.base


import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

abstract class BaseContainerView<T>(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {

    abstract fun bind(item: T)

}
