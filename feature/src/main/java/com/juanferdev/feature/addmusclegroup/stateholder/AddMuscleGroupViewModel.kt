package com.juanferdev.feature.addmusclegroup.stateholder

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.core.data.musclegroup.repositories.MuscleGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMuscleGroupViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository
) : ViewModel() {

    var uiState = mutableStateOf<LocalStoreStatus<Any>?>(null)
        private set


    fun addMuscleGroup(muscleGroup: String) {
        viewModelScope.launch {
            uiState.value = muscleGroupRepository.addMuscleGroup(muscleGroup)
        }
    }

    fun resetUiState() {
        uiState.value = null
    }
}