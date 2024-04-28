package com.juanferdev.core.data.di


import android.content.Context
import androidx.room.Room
import com.juanferdev.core.data.database.AppDatabase
import com.juanferdev.core.data.exercise.datastores.ExerciseDAO
import com.juanferdev.core.data.modality.datastores.ModalityDao
import com.juanferdev.core.data.musclegroup.datastores.MuscleGroupDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "MyGymEvolutionDataBase"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MuscleGroupDao {
        return appDatabase.muscleGroupDao()
    }

    @Provides
    fun provideModalityDao(appDatabase: AppDatabase): ModalityDao {
        return appDatabase.modalityDao()
    }

    @Provides
    fun provideExerciseDao(appDatabase: AppDatabase): ExerciseDAO {
        return appDatabase.exerciseDao()
    }
}