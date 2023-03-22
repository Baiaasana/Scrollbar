package com.example.scrollbar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollbar.data.ServiceModel
import com.example.scrollbar.databinding.CustomServiceItemBinding

class ServiceAdapter :
    ListAdapter<ServiceModel, ServiceAdapter.WalletViewHolder>(ItemCallback) {
    inner class WalletViewHolder(private val binding: CustomServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvTitleService.text = item.title
                ivServiceIcon.setBackgroundResource(item.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder =
        WalletViewHolder(
            CustomServiceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<ServiceModel>() {
        override fun areItemsTheSame(
            oldItem: ServiceModel,
            newItem: ServiceModel,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ServiceModel,
            newItem: ServiceModel,
        ): Boolean {
            return oldItem == newItem
        }
    }
}