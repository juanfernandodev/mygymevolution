package com.juanferdev.feature.settings.stateholder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanferdev.core.data.modality.dto.ModalityDTO
import com.juanferdev.core.data.modality.repositories.ModalityRepository
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val modalityRepository: ModalityRepository
) : ViewModel() {

    val uiStateFlowModalities: StateFlow<List<ModalityDTO>>
        get() = _uiStateFlowModalities

    private var _uiStateFlowModalities = MutableStateFlow<List<ModalityDTO>>(emptyList())

    val uiStateSave: MutableState<LocalStoreStatus<Any>>
        get() = _uiStateSave

    private var _uiStateSave = mutableStateOf<LocalStoreStatus<Any>>(LocalStoreStatus.Completed())

    init {
        getModalities()
    }


    private fun getModalities() {
        viewModelScope.launch {
            modalityRepository.getAllModalities().collect { localStoreStatus ->
                if (localStoreStatus is LocalStoreStatus.Success) {
                    _uiStateFlowModalities.value = localStoreStatus.data
                }
            }
        }
    }

    fun saveModality(name: String) {
        viewModelScope.launch {
            _uiStateSave.value = LocalStoreStatus.Loading()
            _uiStateSave.value = modalityRepository.saveModality(name)
        }
    }
}