package com.example.wthrapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wthrapp.databinding.ItemCityBinding
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.utils.kelvinToCelsius

class CityAdapter() :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var dataSet: List<WeatherInfoResponse> = emptyList()
    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CityViewHolder {
        val binding =
            ItemCityBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: CityViewHolder, position: Int) {

        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun setData(data: List<WeatherInfoResponse>) {
        dataSet = data
    }

    inner class CityViewHolder(private val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(dataSet[adapterPosition].name)
            }
        }

        fun bind(weatherInfo: WeatherInfoResponse) {
            binding.nameText.text = weatherInfo.name
            binding.tempText.text = weatherInfo.main.temp.kelvinToCelsius()
        }
    }
}