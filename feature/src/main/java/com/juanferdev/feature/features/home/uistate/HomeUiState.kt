package com.juanferdev.feature.features.home.uistate

import android.os.Message
import com.juanferdev.feature.features.musclegroups.uistate.ListMuscleGroupUiState

data class HomeUiState(
    val muscleGroups: List<ListMuscleGroupUiState> = listOf(),
    val userMessages: List<Message> = listOf()
)
