package com.example.testactivity.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testactivity.data.model.CardDataItem
import com.example.testactivity.databinding.ItemCardBinding

class ColorsAdapter : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    private var items: List<CardDataItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(color: CardDataItem) {
            with(binding) {
                title.text = color.title
                userName.text = color.userName

                Glide.with(itemView.context).load(color.badgeUrl)
                    .into(binding.card)
            }
        }
    }

    fun setData(items: List<CardDataItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}