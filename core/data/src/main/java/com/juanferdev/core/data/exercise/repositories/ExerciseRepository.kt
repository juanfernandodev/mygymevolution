package com.juanferdev.core.data.exercise.repositories

import com.juanferdev.core.data.database.calls.makeLocalStoreCall
import com.juanferdev.core.data.exercise.datastores.ExerciseDAO
import com.juanferdev.core.data.exercise.dto.ExerciseDTO
import com.juanferdev.core.data.exercise.mapper.ExerciseMapper
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val exerciseDAO: ExerciseDAO
) {

    fun getExerciseByMuscleGroup(muscleGroupId: Int): Flow<LocalStoreStatus<List<ExerciseDTO>>> {
        return flow {
            exerciseDAO.getExerciseByMuscleGroup(
                muscleGroupId = muscleGroupId
            ).collect { listExerciseModel ->
                val listExerciseDTO =
                    ExerciseMapper().mapperExerciseModelListToExerciseDTOList(listExerciseModel)
                emit(LocalStoreStatus.Success(listExerciseDTO))
            }
        }.flowOn(dispatcher)
    }

    suspend fun insertExercise(exerciseDTO: ExerciseDTO): LocalStoreStatus<Any> {
        return makeLocalStoreCall(dispatcher) {
            val muscleGroupModel = ExerciseMapper().mapperExerciseDTOToExerciseModel(exerciseDTO)
            exerciseDAO.insertExercise(muscleGroupModel)
        }
    }

}