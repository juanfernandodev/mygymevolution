package com.juanferdev.core.data.exercise.datastores

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juanferdev.core.data.exercise.models.ExerciseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDAO {

    @Query("SELECT * FROM ExerciseModel WHERE muscleGroupId = :muscleGroupId")
    fun getExerciseByMuscleGroup(muscleGroupId: Int): Flow<List<ExerciseModel>>

    @Insert()
    suspend fun insertExercise(exerciseModel: ExerciseModel)
}