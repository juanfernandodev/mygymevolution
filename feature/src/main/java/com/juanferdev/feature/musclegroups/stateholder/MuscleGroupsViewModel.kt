package com.juanferdev.feature.features.musclegroups.stateholder

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.core.data.musclegroup.repositories.MuscleGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MuscleGroupsViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository
) : ViewModel() {

    var uiState =
        mutableStateOf<LocalStoreStatus<List<MuscleGroupModel>>>(LocalStoreStatus.Loading())
        private set


    fun getListMuscleGroup() {
        viewModelScope.launch {
            uiState.value = LocalStoreStatus.Loading()
            uiState.value = muscleGroupRepository.getAllMuscleGroup()
        }
    }


}