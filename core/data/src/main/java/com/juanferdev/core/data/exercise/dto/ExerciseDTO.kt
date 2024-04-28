package com.juanferdev.core.data.exercise.dto

data class ExerciseDTO(
    val id: Int,
    val name: String,
    val weight: Int = 0,
    val reps: Int = 0,
    val notes: String = String(),
    val muscleGroupId: Int,
    val idModalityDTO: Int,
    val lastModification: String = String()
)
