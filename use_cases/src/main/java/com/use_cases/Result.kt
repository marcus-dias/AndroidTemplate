package com.use_cases

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    class UnknownError<T> : DomainResult<T>()
    class ConnectionError<T> : DomainResult<T>()
}
