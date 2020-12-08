package com.view_models.extensions

import androidx.lifecycle.viewModelScope
import com.domain_model.DomainResult
import com.ui_model.errors.UiErrorState
import com.view_models.base.BaseViewModel
import kotlinx.coroutines.launch

fun <T> BaseViewModel.isSuccess(
    result: DomainResult<T>,
    onSuccess: ((T) -> Unit)
) {
    when (result) {
        is DomainResult.Success -> showSuccess(onSuccess, result)
        is DomainResult.NetworkError -> showNetworkError()
        is DomainResult.UnknownError -> showUnknownError()
        is DomainResult.DatabaseError -> showDatabaseError()
    }
}

private fun BaseViewModel.showNetworkError() {
    hideLoading()
    showError(UiErrorState.NetworkError)
}

private fun BaseViewModel.showUnknownError() {
    hideLoading()
    showError(UiErrorState.UnknownError)
}

private fun BaseViewModel.showDatabaseError() {
    hideLoading()
    showError(UiErrorState.DatabaseError)
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