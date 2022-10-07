package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.ecriture.databinding.ItemBannerBinding
import com.app.ecriture.dummydata.Banner

class BannerAdapter():ListAdapter<Banner, BannerAdapter.ViewHolder>(BannerDiffUtils) {

    inner class ViewHolder(val binding:ItemBannerBinding):RecyclerView.ViewHolder(binding.root)

    object BannerDiffUtils:DiffUtil.ItemCallback<Banner>(){
        override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBannerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner  = getItem(position)
        holder.binding.apply {
            ivBanner.load(banner.image)
            tvDescription.text=banner.text
        }
    }
}