package com.template.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.base_ui.model.Loading
import com.template.R
import dagger.hilt.android.AndroidEntryPoint

fun createMainFragment() = MainFragment()

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel by viewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCountriesObserver()
        viewModel.loadAllCountries()
    }

    private fun setupCountriesObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            if (it is Loading) {
                Toast.makeText(context, "loading", Toast.LENGTH_SHORT).show()
            }
        }
    }
}