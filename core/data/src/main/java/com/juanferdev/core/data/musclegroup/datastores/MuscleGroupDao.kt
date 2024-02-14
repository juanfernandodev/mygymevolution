package com.juanferdev.core.data.musclegroup.datastores

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MuscleGroupDao {

    @Query("SELECT * FROM musclegroupmodel")
    fun getAll(): Flow<List<MuscleGroupModel>>

    @Upsert
    fun upsert(muscleGroupModel: MuscleGroupModel)


    @Delete
    fun delete(muscleGroupModel: MuscleGroupModel)
}