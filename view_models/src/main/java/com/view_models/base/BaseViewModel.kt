package com.view_models.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ui_model.errors.UiErrorState

abstract class BaseViewModel : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    private val _showErrorState = MutableLiveData<UiErrorState>()
    val loadingState: LiveData<Boolean> = _loadingState
    val errorState: LiveData<UiErrorState> = _showErrorState
    internal fun showLoading() = _loadingState.postValue(true)
    internal fun hideLoading() = _loadingState.postValue(false)
    internal fun showError(uiErrorState: UiErrorState) = _showErrorState.postValue(uiErrorState)
    internal fun hideError() = _showErrorState.postValue(null)
}