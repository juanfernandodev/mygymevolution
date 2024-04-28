package com.juanferdev.core.data.musclegroup.repositories

import com.juanferdev.core.data.database.calls.makeLocalStoreCall
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.dto.MuscleGroupDTO
import com.juanferdev.core.data.musclegroup.mapper.MuscleGroupMapper
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MuscleGroupRepository @Inject constructor(
    private val muscleGroupDao: MuscleGroupDao,
    private val dispatcher: CoroutineDispatcher
) {

    fun getAllMuscleGroup(): Flow<LocalStoreStatus<List<MuscleGroupDTO>>> {
        return flow {
            muscleGroupDao.getAll().collect { listMuscleGroupModel ->
                val listMuscleGroupDTO =
                    MuscleGroupMapper().mapperListMuscleGroupModelToListMuscleGroupDTO(
                        listMuscleGroupModel = listMuscleGroupModel
                    )
                emit(LocalStoreStatus.Success(listMuscleGroupDTO))
            }
        }.flowOn(dispatcher)
    }


    suspend fun addMuscleGroup(muscleGroup: String): LocalStoreStatus<Any> =
        makeLocalStoreCall(dispatcher) {
            val muscleGroupModel = MuscleGroupModel(name = muscleGroup)
            muscleGroupDao.insert(muscleGroupModel)
        }
}


