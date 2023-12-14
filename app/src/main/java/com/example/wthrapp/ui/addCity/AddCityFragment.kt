package com.example.wthrapp.ui.addCity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wthrapp.R
import com.example.wthrapp.databinding.AddCityFragmentBinding
import com.example.wthrapp.ui.addCity.adapter.CityListAdapter
import com.example.wthrapp.utils.popBackStack

class AddCityFragment() : Fragment(R.layout.add_city_fragment),
    AddCityContract.View {

    private lateinit var binding: AddCityFragmentBinding

    private val cityList =
        listOf(
            "Almaty",
            "Astana",
            "Kostanay",
            "Kokshetau",
            "Aktau",
            "Atyrau",
            "Aktobe",
            "Pavlodar",
            "Shymkent",
            "Taraz",
            "Semey"
        )

    private val presenter = AddCityPresenter()
    private var adapter = CityListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddCityFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.saveContext(requireContext())
        initAdapter()
    }

    private fun initAdapter() = with(binding) {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.setData(cityList)
        adapter.onItemClick = {
            presenter.addCity(it)

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun closeFragment() {
        popBackStack()
    }
}