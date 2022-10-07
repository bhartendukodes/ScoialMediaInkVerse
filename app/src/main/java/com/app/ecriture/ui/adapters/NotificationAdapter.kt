package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.ecriture.databinding.ItemNotificationBinding
import com.app.ecriture.dummydata.NotificationData

class NotificationAdapter :
    ListAdapter<NotificationData, NotificationAdapter.MyViewHolder>(NotificationDiffUtils) {

    inner class MyViewHolder(val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root)

    object NotificationDiffUtils : DiffUtil.ItemCallback<NotificationData>() {
        override fun areItemsTheSame(
            oldItem: NotificationData,
            newItem: NotificationData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NotificationData,
            newItem: NotificationData
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(
                    parent.context),
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            ivProfile.load(data.profile)
            tvCommentTitle.text=data.name.plus(" liked your post")
            tvDuration.text=data.time
        }

    }
}