package com.example.aorjclxvuc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aorjclxvuc.databinding.ViewCurrencyListInfoItemBinding
import com.example.aorjclxvuc.model.CurrencyInfo
import com.example.aorjclxvuc.utils.onSingleClick

class CurrencyListAdapter :
    ListAdapter<CurrencyInfo, CurrencyListAdapter.CurrencyListItemViewHolder>(
        CurrencyListDiffCallback()
    ) {

    var onItemClickListener: ((item: CurrencyInfo) -> Unit)? = null

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

    inner class CurrencyListItemViewHolder(
        private val binding: ViewCurrencyListInfoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CurrencyInfo) {
            binding.item = item
            binding.root.onSingleClick {
                onItemClickListener?.invoke(item)
            }
        }
    }

    class CurrencyListDiffCallback : DiffUtil.ItemCallback<CurrencyInfo>() {

        override fun areItemsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean =
            oldItem == newItem
    }
}
