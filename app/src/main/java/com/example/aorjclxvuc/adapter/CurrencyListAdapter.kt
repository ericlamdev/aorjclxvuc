package com.example.aorjclxvuc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aorjclxvuc.databinding.ViewCurrencyListInfoItemBinding
import com.example.aorjclxvuc.model.CurrencyInfo

class CurrencyListAdapter :
    ListAdapter<CurrencyInfo, CurrencyListAdapter.CurrencyListItemViewHolder>(
        CurrencyListDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListItemViewHolder =
        CurrencyListItemViewHolder(
            ViewCurrencyListInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CurrencyListItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    class CurrencyListItemViewHolder(
        private val binding: ViewCurrencyListInfoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CurrencyInfo) {
            binding.item = item
        }
    }

    class CurrencyListDiffCallback : DiffUtil.ItemCallback<CurrencyInfo>() {

        override fun areItemsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean =
            oldItem == newItem
    }
}
