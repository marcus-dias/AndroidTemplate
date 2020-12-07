package com.template

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe

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
                Toast.makeText(context, "show loadingState", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "hide loadingState", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupErrorObserver() {
        viewModel.errorState.observe(viewLifecycleOwner) { showError ->
            if (showError) {
                Toast.makeText(context, "show Error", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "hide Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
