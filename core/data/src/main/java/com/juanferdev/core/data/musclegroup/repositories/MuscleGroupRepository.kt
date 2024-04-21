package com.juanferdev.core.data.musclegroup.repositories

import com.juanferdev.core.data.database.calls.makeLocalStoreCall
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MuscleGroupRepository @Inject constructor(
    private val muscleGroupDao: MuscleGroupDao,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getAllMuscleGroup(): LocalStoreStatus<List<MuscleGroupModel>> =
        makeLocalStoreCall(dispatcher) {
            muscleGroupDao.getAll()
        }

    suspend fun addMuscleGroup(muscleGroup: String): LocalStoreStatus<Any> =
        makeLocalStoreCall(dispatcher) {
            val muscleGroupModel = MuscleGroupModel(name = muscleGroup)
            muscleGroupDao.insert(muscleGroupModel)
        }
}


