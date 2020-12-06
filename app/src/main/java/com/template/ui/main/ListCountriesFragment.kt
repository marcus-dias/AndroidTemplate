package com.template.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.template.BaseFragment
import com.template.R
import com.view_models.country.ListCountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

fun createMainFragment() = ListCountriesFragment()

@AndroidEntryPoint
class ListCountriesFragment : BaseFragment<ListCountriesViewModel>(R.layout.main_fragment) {
    override val viewModel by viewModels<ListCountriesViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCountriesObserver()
        viewModel.loadAllCountries()
    }

    private fun setupCountriesObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            //display list of countries
        }
    }
}