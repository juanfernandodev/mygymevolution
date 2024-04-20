package com.juanferdev.core.data.musclegroup.repositories

import com.juanferdev.core.data.R
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MuscleGroupRepository @Inject constructor(
    private val muscleGroupDao: MuscleGroupDao,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getAllMuscleGroup(): LocalStoreStatus<List<MuscleGroupModel>> =
        withContext(dispatcher) {
            try {
                LocalStoreStatus.Success(muscleGroupDao.getAll())
            } catch (e: Exception) {
                LocalStoreStatus.Error(R.string.there_was_error)
            }
        }
}


