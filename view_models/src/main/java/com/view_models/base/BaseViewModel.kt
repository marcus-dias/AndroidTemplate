package com.view_models.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    private val _showErrorState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState
    val errorState: LiveData<Boolean> = _showErrorState
    internal fun showLoading() = _loadingState.postValue(true)
    internal fun hideLoading() = _loadingState.postValue(false)
    internal fun showError() = _showErrorState.postValue(true)
    internal fun hideError() = _showErrorState.postValue(false)
}