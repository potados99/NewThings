package com.potados.newthings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.properties.Delegates

class ListRecyclerViewAdapter : RecyclerView.Adapter<ListRecyclerViewAdapter.ListViewHolder>() {

    private var collection: List<Dummy.DummyItem> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    fun setData(collection: List<Dummy.DummyItem>) {
        this.collection = collection
    }

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(collection[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder.from(parent)

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val idTextView = view.list_item_id_textview
        private val titleTextView = view.list_item_title_textview
        private val descriptionTextView = view.list_item_description_textview

        fun bind(item: Dummy.DummyItem) {
            idTextView.text = item.id.toString()
            titleTextView.text = item.title
            descriptionTextView.text = item.description
        }

        companion object {
            fun from(parent: ViewGroup): ListViewHolder {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.list_item, parent, false)

                return ListViewHolder(view)
            }
        }
    }

}