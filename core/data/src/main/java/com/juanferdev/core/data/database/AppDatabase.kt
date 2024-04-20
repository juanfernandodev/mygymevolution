package com.juanferdev.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel

@Database(entities = [MuscleGroupModel::class], version = 0)
abstract class AppDatabase : RoomDatabase() {

    abstract fun muscleGroupDao(): MuscleGroupDao

}