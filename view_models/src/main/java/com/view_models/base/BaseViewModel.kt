package com.view_models.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    private val _showErrorState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState
    val errorState: LiveData<Boolean> = _showErrorState
    protected fun showLoading() = _loadingState.postValue(true)
    protected fun hideLoading() = _loadingState.postValue(false)
    protected fun showError() = _showErrorState.postValue(true)
    protected fun hideError() = _showErrorState.postValue(false)
}