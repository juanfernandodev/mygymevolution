package com.juanferdev.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel

@Database(entities = [MuscleGroupModel::class], version = 0)
abstract class AppDatabase(context: Context) : RoomDatabase() {

    abstract fun muscleGroupDao(): MuscleGroupDao

    companion object {
        private var INSTANCE_APP_DATABASE: AppDatabase? = null

        fun instance(context: Context): AppDatabase =
            INSTANCE_APP_DATABASE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "MyGymEvolutionDataBase"
                ).fallbackToDestructiveMigration().build()
                INSTANCE_APP_DATABASE = instance
                instance
            }
    }
}