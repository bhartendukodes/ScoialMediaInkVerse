package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.ecriture.databinding.ItemPostBinding
import com.app.ecriture.dummydata.Genere
import com.app.ecriture.dummydata.Genere.WriteUpPage

class FeedAdapter(): ListAdapter<Genere.WriteUpPage, FeedAdapter.MyViewHolder>(DetailDiffUtils) {

    inner class MyViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root)

    object DetailDiffUtils : DiffUtil.ItemCallback<Genere.WriteUpPage>() {
        override fun areItemsTheSame(
            oldItem: WriteUpPage,
            newItem: WriteUpPage
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: WriteUpPage,
            newItem: WriteUpPage
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            ivPostedData.load(data.profilePicture)
            tvTime.text=data.date
            tvCaption.text=data.data
            tvHashTag.text=data.hashTagData
        }
    }
}