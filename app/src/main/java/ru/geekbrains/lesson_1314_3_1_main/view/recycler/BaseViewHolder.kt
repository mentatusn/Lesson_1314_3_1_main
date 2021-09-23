package ru.geekbrains.lesson_1314_3_1_main.view.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(pair: Pair<Data,Boolean>)
}