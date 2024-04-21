package com.juanferdev.core.data.musclegroup.datastores

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel

@Dao
interface MuscleGroupDao {

    @Query("SELECT * FROM musclegroupmodel")
    fun getAll(): List<MuscleGroupModel>

    @Insert
    fun insert(muscleGroupModel: MuscleGroupModel)


    @Delete
    fun delete(muscleGroupModel: MuscleGroupModel)
}