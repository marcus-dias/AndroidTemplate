package com.view_models.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.use_cases.DomainResult
import kotlinx.coroutines.launch

fun <T> ViewModel.isSuccess(result: DomainResult<T>, onSuccess: ((T) -> Unit)) {
    when (result) {
        is DomainResult.Success -> onSuccess.invoke(result.data)
        is DomainResult.UnknownError -> {
        }
        is DomainResult.ConnectionError -> {
        }
    }
}

fun <T> ViewModel.executeUseCase(
    useCaseInvoke: suspend () -> DomainResult<T>,
    onSuccess: (T) -> Unit
) {
    viewModelScope.launch {
        isSuccess(useCaseInvoke.invoke(), onSuccess)
    }
}