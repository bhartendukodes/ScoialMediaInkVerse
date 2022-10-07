package com.app.ecriture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.ecriture.R
import com.app.ecriture.databinding.ItemGenereBinding
import com.app.ecriture.dummydata.Genere

class GenereAdapter(val allowToProceed: (Boolean) -> Unit) :
    ListAdapter<Genere, GenereAdapter.MyViewHolder>(DetailDiffUtils) {

    private val selectedGenre: MutableSet<Int> = mutableSetOf()

    inner class MyViewHolder(val binding: ItemGenereBinding) :
        RecyclerView.ViewHolder(binding.root)

    object DetailDiffUtils : DiffUtil.ItemCallback<Genere>() {
        override fun areItemsTheSame(
            oldItem: Genere,
            newItem: Genere
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Genere,
            newItem: Genere
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemGenereBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val genere = getItem(position)
        holder.binding.apply {

            root.setOnClickListener {

                if (selectedGenre.contains(genere.id))
                    selectedGenre.remove(genere.id)
                else selectedGenre.add(genere.id)

                allowToProceed.invoke(selectedGenre.size >= 3)
                notifyDataSetChanged()
            }

            if (selectedGenre.contains(genere.id)) {
                root.setCardBackgroundColor(
                    ActivityCompat.getColor(
                        root.context,
                        R.color.blue_teal
                    )
                )
            } else {
                root.setCardBackgroundColor(ActivityCompat.getColor(root.context, R.color.white))
            }
            edView.text = genere.genereType
        }
    }
}