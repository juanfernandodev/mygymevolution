package com.juanferdev.core.data.database.calls

import com.juanferdev.core.data.R
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T> makeLocalStoreCall(
    dispatcher: CoroutineDispatcher,
    call: (() -> T)
): LocalStoreStatus<T> =
    withContext(dispatcher) {
        try {
            val callResponse = call()
            LocalStoreStatus.Success(callResponse)
        } catch (e: Exception) {
            val excepcion = e
            LocalStoreStatus.Error(R.string.there_was_error)
        }
    }