package com.juanferdev.core.data.exercise.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val weight: Int = 0,
    val reps: Int = 0,
    val notes: String = String(),
    val muscleGroupId: Int,
    val idModalityDTO: Int,
    val lastModification: String = String()
)
