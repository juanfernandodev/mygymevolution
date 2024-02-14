package com.juanferdev.feature.features.exercises.uistate

import android.media.Image

data class ExerciseUiState(
    val id: Int,
    val name: String,
    val weight: Int,
    val image: Image,
    val reps: Int,
    val notes: String,
    val idMuscleGroup: Int,
    val modality: String
)
