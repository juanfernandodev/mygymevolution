package com.juanferdev.feature.features.musclegroups.stateholder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MuscleGroupsViewModel : ViewModel() {
    private val listMuscleGroup =
        listOf("Quadriceps", "Adductors", "Femoral", "Gluteus", "Triceps", "Biceps")

    private val _uiState: MutableState<List<String>> = mutableStateOf(emptyList())

    init {
        _uiState.value = listMuscleGroup
    }

    val uiState: MutableState<List<String>>
        get() = _uiState

}