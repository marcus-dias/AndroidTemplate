package com.template

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.view_models.base.BaseViewModel

abstract class BaseFragment<VM : com.view_models.base.BaseViewModel>(@LayoutRes layoutResId: Int) :
    Fragment(layoutResId) {
    abstract val viewModel: VM
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        setupLoadingObserver()
        setupErrorObserver()
    }

    private fun setupLoadingObserver() {
        viewModel.loadingState.observe(viewLifecycleOwner) { showLoading ->
            if (showLoading) {
                Toast.makeText(context, "loading loadingState", Toast.LENGTH_SHORT).show()
            } else {
            }
        }
    }

    private fun setupErrorObserver() {
        viewModel.errorState.observe(viewLifecycleOwner) { showError ->
            if (showError) {
            } else {
            }
        }
    }
}
