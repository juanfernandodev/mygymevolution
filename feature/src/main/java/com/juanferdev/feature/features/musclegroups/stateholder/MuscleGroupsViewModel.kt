package com.juanferdev.feature.features.musclegroups.stateholder

import androidx.lifecycle.ViewModel
import com.juanferdev.feature.features.musclegroups.uistate.ListMuscleGroupUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MuscleGroupsViewModel : ViewModel() {
    val listMuscleGroup =
        listOf("Quadriceps", "Adductors", "Femoral", "Gluteus", "Triceps", "Biceps")
    private val _uiState = MutableStateFlow(ListMuscleGroupUiState())
    val uiState: StateFlow<ListMuscleGroupUiState> = _uiState.asStateFlow()

}