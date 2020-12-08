package com.template.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.base_ui.extensions.toggleVisibility
import com.template.R
import com.ui_model.errors.UiErrorState
import com.view_models.base.BaseViewModel
import kotlinx.android.synthetic.main.base_fragment_layout.*

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {
    abstract val viewModel: VM?
    abstract fun doInitializations()
    abstract fun setupObservers()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val baseView =
            inflater.inflate(
                R.layout.base_fragment_layout,
                container,
                false
            ) as ViewGroup
        val content = inflater.inflate(
            layoutResId,
            baseView,
            false
        )
        baseView.addView(content, 0)
        return baseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        setupLoadingObserver()
        setupErrorObserver()
        setupObservers()
        doInitializations()
    }

    private fun setupLoadingObserver() {
        viewModel?.loadingState?.observe(viewLifecycleOwner) { showLoading ->
            baseLoadingProgressBar.toggleVisibility(showLoading)
        }
    }

    private fun setupErrorObserver() {
        viewModel?.errorState?.observe(viewLifecycleOwner) { uiErrorState ->
            when (uiErrorState) {
                UiErrorState.NetworkError -> showNetworkError()
                UiErrorState.DatabaseError -> showUnknownError()
                UiErrorState.UnknownError -> showDatabaseError()
                else -> hideError()
            }
        }
    }

    private fun hideError() {
        Toast.makeText(context, "hide Error", Toast.LENGTH_SHORT).show()
    }

    private fun showNetworkError() {
        Toast.makeText(context, "show showNetworkError", Toast.LENGTH_SHORT).show()
    }

    private fun showUnknownError() {
        Toast.makeText(context, "show showUnknownError", Toast.LENGTH_SHORT).show()
    }

    private fun showDatabaseError() {
        Toast.makeText(context, "show showDatabaseError", Toast.LENGTH_SHORT).show()
    }
}
