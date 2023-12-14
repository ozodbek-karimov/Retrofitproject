package com.devtides.retrofitproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.retrofitproject.R
import com.devtides.retrofitproject.model.Item
import com.devtides.retrofitproject.model.TYPE_ITEM
import kotlinx.android.synthetic.main.category_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter(val items: ArrayList<Item>): RecyclerView.Adapter<ListAdapter.AdapterViewHolder>() {

    fun updateItems(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return if (viewType == TYPE_ITEM)
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
        else
            CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    abstract class AdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Item)
    }

    class ItemViewHolder(view: View): AdapterViewHolder(view) {
        private val title = view.item_title
        private val text = view.item_text
        override fun bind(item: Item) {
            title.text = item.key
            text.text = item.value
        }
    }

    class CategoryViewHolder(view: View): AdapterViewHolder(view) {
        private val categoryTitle = view.category_title
        override fun bind(item: Item) {
            categoryTitle.text = item.key.toUpperCase(Locale.ROOT)
        }
    }
}