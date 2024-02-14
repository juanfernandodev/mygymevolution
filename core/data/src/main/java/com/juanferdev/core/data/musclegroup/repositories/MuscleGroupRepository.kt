package com.juanferdev.core.data.musclegroup.repositories

import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.flow.Flow

class MuscleGroupRepository(private val muscleGroupDao: MuscleGroupDao) {

    //val data: Flow<Example> = ...

    fun getAllMuscleGroup(): Flow<List<MuscleGroupModel>> = muscleGroupDao.getAll()

}