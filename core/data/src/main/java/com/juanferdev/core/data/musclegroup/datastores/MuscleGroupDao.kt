package com.juanferdev.core.data.musclegroup.datastores

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MuscleGroupDao {

    @Query("SELECT * FROM musclegroupmodel")
    fun getAll(): Flow<List<MuscleGroupModel>>

    @Insert
    suspend fun insert(muscleGroupModel: MuscleGroupModel)


    @Delete
    suspend fun delete(muscleGroupModel: MuscleGroupModel)
}