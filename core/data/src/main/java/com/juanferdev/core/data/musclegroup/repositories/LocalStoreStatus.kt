package com.juanferdev.core.data.musclegroup.repositories

sealed class LocalStoreStatus<T> {

    class Success<T>(val data: T) : LocalStoreStatus<T>()

    class Error<T>(val messageId: Int) : LocalStoreStatus<T>()

    class Loading<T> : LocalStoreStatus<T>()
}