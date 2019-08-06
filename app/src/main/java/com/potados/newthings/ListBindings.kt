package com.potados.newthings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("items")
fun setItems(listView: RecyclerView, items: List<Dummy.DummyItem>) {
    (listView.adapter as ListRecyclerViewAdapter).setData(items)
}