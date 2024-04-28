package com.juanferdev.feature.features.musclegroups.stateholder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanferdev.core.data.musclegroup.dto.MuscleGroupDTO
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.core.data.musclegroup.repositories.MuscleGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MuscleGroupsViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository
) : ViewModel() {

    var uiStateFlow =
        MutableStateFlow<LocalStoreStatus<List<MuscleGroupDTO>>>(LocalStoreStatus.Loading())
        private set

    init {
        getListMuscleGroup()
    }

    private fun getListMuscleGroup() {
        viewModelScope.launch {
            uiStateFlow.value = LocalStoreStatus.Loading()
            muscleGroupRepository.getAllMuscleGroup().collect { localStoreStatus ->
                uiStateFlow.value = localStoreStatus
            }
        }
    }


}