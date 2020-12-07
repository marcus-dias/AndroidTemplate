package com.domain_model

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    class UnknownError<T> : DomainResult<T>()
    class NetworkError<T> : DomainResult<T>()
    class DatabaseError<T> : DomainResult<T>()
}