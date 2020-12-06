package com.use_cases.extensions

import com.use_cases.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> UseCase.executeIoOperation(crossinline repositoryCall: suspend () -> T) =
    withContext(Dispatchers.IO) {
        return@withContext repositoryCall.invoke()
    }
