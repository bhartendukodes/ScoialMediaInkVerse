package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.ecriture.databinding.ItemProfilePostBinding
import com.app.ecriture.databinding.ItemSearchPostBinding
import com.app.ecriture.dummydata.SearchList

class ProfileAdapter(): ListAdapter<SearchList, ProfileAdapter.MyViewHolder>(SearchDiffUtils) {

    object SearchDiffUtils: DiffUtil.ItemCallback<SearchList>() {
        override fun areItemsTheSame(oldItem: SearchList, newItem: SearchList): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchList, newItem: SearchList): Boolean {
            return oldItem==newItem
        }
    }

    inner class MyViewHolder(val binding:ItemProfilePostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemProfilePostBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)

        holder.binding.apply {
            ivPostedData.load(data.profileImage)
        }
    }
}