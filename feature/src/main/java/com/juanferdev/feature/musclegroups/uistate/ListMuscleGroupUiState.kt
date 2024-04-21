package com.juanferdev.feature.features.musclegroups.uistate

import android.os.Message

data class ListMuscleGroupUiState(
    val listMuscleGroupUiState: List<MuscleGroupUiState> = emptyList(),
    val userMessages: List<Message> = listOf()
)
