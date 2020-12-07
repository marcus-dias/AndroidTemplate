package com.repositories

import com.domain_model.DomainResult
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T> safeCallToResult(call: suspend () -> T): DomainResult<T> {
        return runCatching {
            call()
        }.fold(::onSuccess, ::onFailure)
    }

    private fun <T> onFailure(it: Throwable): DomainResult<T> {
        return when (it) {
            is IOException -> DomainResult.NetworkError()
            else -> DomainResult.UnknownError()
        }
    }

    private fun <T> onSuccess(it: T): DomainResult<T> = DomainResult.Success(it)
}