package com.albert.homemodule

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.albert.homemodule.placeholder.PlaceholderContent.PlaceholderItem
import com.albert.homemodule.databinding.FragmentPostBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MypostsRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val postItemClickListener: OnPostItemClickListener
) : RecyclerView.Adapter<MypostsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentPostBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val cardHolder = binding.root

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

        fun bind(item: PlaceholderItem) {
            idView.text = item.content
            contentView.text = item.details
            cardHolder.setOnClickListener {
                postItemClickListener.onClick(item)
            }
        }
    }

    interface OnPostItemClickListener {
        fun onClick(id: PlaceholderItem)
    }
}