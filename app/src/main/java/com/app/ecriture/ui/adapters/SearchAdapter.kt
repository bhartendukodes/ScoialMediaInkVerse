package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.ecriture.databinding.ItemSearchPostBinding
import com.app.ecriture.dummydata.SearchList

class SearchAdapter(): ListAdapter<SearchList, SearchAdapter.MyViewHolder>(SearchDiffUtils) {

    object SearchDiffUtils: DiffUtil.ItemCallback<SearchList>() {
        override fun areItemsTheSame(oldItem: SearchList, newItem: SearchList): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchList, newItem: SearchList): Boolean {
            return oldItem==newItem
        }
    }

    inner class MyViewHolder(val binding:ItemSearchPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemSearchPostBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)

        holder.binding.apply {
            ivProfile.load(data.profileImage)
            tvProfileName.text=data.name
            tvCaptions.text=data.caption
            ivPostedData.load(data.image)
        }
    }
}