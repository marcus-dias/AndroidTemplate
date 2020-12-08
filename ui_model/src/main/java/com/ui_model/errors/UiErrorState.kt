package com.ui_model.errors

sealed class UiErrorState {
    object UnknownError : UiErrorState()
    object NetworkError : UiErrorState()
    object DatabaseError : UiErrorState()
}