package com.example.wthrapp.ui.addCity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wthrapp.databinding.ItemAddCityBinding

class CityListAdapter :
    RecyclerView.Adapter<CityListAdapter.CityListViewHolder>() {

    private var dataSet: List<String> = emptyList()
    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CityListViewHolder {
        val binding =
            ItemAddCityBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CityListViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: CityListViewHolder, position: Int) {

        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun setData(data: List<String>) {
        dataSet = data
    }

    inner class CityListViewHolder(private val binding: ItemAddCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(dataSet[adapterPosition])
            }
        }

        fun bind(name: String) {
            binding.nameText.text = name
        }
    }
}