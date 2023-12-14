package com.example.wthrapp.ui.cityDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.wthrapp.R
import com.example.wthrapp.databinding.CityDetailFragmentBinding
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.utils.*

private const val CITY_NAME = "CITY_NAME"

class CityDetailFragment : Fragment(R.layout.city_detail_fragment), CityDetailContract.View {

    private lateinit var binding: CityDetailFragmentBinding

    private val presenter = CityDetailPresenter()

    private var cityName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cityName = arguments?.getString(CITY_NAME)!!
        binding = CityDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        presenter.getWeather(cityName)
    }

    override fun setData(data: WeatherInfoResponse) = with(binding) {
        tempText.text = data.main.temp.kelvinToCelsius()
        mainText.text = data.weather.first().main
        timeText.text = data.dt.millisToDate()
        humidityText.text = data.main.humidity.withPercent()
        pressureText.text = data.main.pressure.toString()
        windText.text = data.wind.speed.toMS()
        sunriseText.text = data.sys.sunrise.millisToDateHHMM()
        sunsetText.text = data.sys.sunset.millisToDateHHMM()

        mainLayout.isVisible = true
        secondaryLayout.isVisible = true
        progressBar.isVisible = false
    }

    private fun initViews() = with(binding) {
        mainLayout.isVisible = false
        secondaryLayout.isVisible = false
        progressBar.isVisible = true
        nameText.text = cityName
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


    companion object {
        fun newInstance(cityName: String): CityDetailFragment {
            val fragment = CityDetailFragment()
            val bundle = Bundle()
            bundle.putString(CITY_NAME, cityName)
            fragment.arguments = bundle
            return fragment
        }
    }
}