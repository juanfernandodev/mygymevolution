package com.juanferdev.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanferdev.core.data.exercise.datastores.ExerciseDAO
import com.juanferdev.core.data.modality.datastores.ModalityDao
import com.juanferdev.core.data.modality.models.ModalityModel
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel

@Database(entities = [MuscleGroupModel::class, ModalityModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun muscleGroupDao(): MuscleGroupDao

    abstract fun modalityDao(): ModalityDao

    abstract fun exerciseDao(): ExerciseDAO

}