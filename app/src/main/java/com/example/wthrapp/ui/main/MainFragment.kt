package com.example.wthrapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wthrapp.R
import com.example.wthrapp.databinding.MainFragmentBinding
import com.example.wthrapp.ui.addCity.AddCityFragment
import com.example.wthrapp.ui.cityDetail.CityDetailFragment
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.ui.main.adapter.CityAdapter
import com.example.wthrapp.utils.addFragment

class MainFragment : Fragment(R.layout.main_fragment), MainContract.View {
    private lateinit var binding: MainFragmentBinding

    private val presenter = MainPresenter()
    private var adapter = CityAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initAdapter()
    }

    override fun onResume() = with(binding) {
        super.onResume()
        recyclerView.isVisible = false
        progressBar.isVisible = true
        presenter.getWeathers(requireContext())
    }

    override fun setData(response: List<WeatherInfoResponse>) = with(binding) {
        recyclerView.isVisible = true
        progressBar.isVisible = false
        adapter.setData(response)
        adapter.notifyDataSetChanged()
    }

    override fun onRemove() {
        onResume()
    }

    private fun initAdapter() = with(binding) {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.onItemClick = {
            addFragment(CityDetailFragment.newInstance(it), parentFragmentManager)
        }
    }

    private fun initViews() = with(binding) {
        addCityButton.setOnClickListener {
            addFragment(AddCityFragment(), parentFragmentManager)
        }
        clearButton.setOnClickListener {
            presenter.removeCities(requireContext())
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
}