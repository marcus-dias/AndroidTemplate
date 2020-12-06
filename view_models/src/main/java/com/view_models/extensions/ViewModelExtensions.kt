package com.view_models.extensions

import androidx.lifecycle.viewModelScope
import com.domain_model.DomainResult
import com.view_models.base.BaseViewModel
import kotlinx.coroutines.launch

fun <T> BaseViewModel.isSuccess(result: DomainResult<T>, onSuccess: ((T) -> Unit)) {
    when (result) {
        is DomainResult.Success -> showSuccess(onSuccess, result)
        is DomainResult.UnknownError -> showError()
        is DomainResult.ConnectionError -> showError()
    }
}

private fun BaseViewModel.showError() {
    hideLoading()
    showError()
}

private fun <T> BaseViewModel.showSuccess(
    onSuccess: (T) -> Unit,
    result: DomainResult.Success<T>
) {
    hideLoading()
    hideError()
    onSuccess.invoke(result.data)
}

fun <T> BaseViewModel.executeUseCase(
    useCaseInvoke: suspend () -> DomainResult<T>,
    onSuccess: (T) -> Unit
) {
    viewModelScope.launch {
        isSuccess(useCaseInvoke.invoke(), onSuccess)
    }
}