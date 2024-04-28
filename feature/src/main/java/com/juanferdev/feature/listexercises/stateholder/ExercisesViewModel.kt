package com.juanferdev.feature.listexercises.stateholder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanferdev.core.data.exercise.dto.ExerciseDTO
import com.juanferdev.core.data.exercise.repositories.ExerciseRepository
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    var uiStateFlowExercises =
        MutableStateFlow<LocalStoreStatus<List<ExerciseDTO>>>(LocalStoreStatus.Loading())
        private set

    private var _uiStateExercises =
        mutableStateOf<LocalStoreStatus<Any>>(LocalStoreStatus.Completed())

    val uiStateExercise: MutableState<LocalStoreStatus<Any>>
        get() = _uiStateExercises

    fun getExercisesByMuscleGroup(muscleGroupId: Int) {
        viewModelScope.launch {
            _uiStateExercises.value = LocalStoreStatus.Loading()
            exerciseRepository.getExerciseByMuscleGroup(
                muscleGroupId = muscleGroupId
            ).collect { localStoreStatus ->
                uiStateFlowExercises.value = localStoreStatus
            }
        }
    }

    fun insertExercise(
        id: Int,
        name: String,
        weight: Int = 0,
        reps: Int = 0,
        notes: String = String(),
        muscleGroupId: Int,
        idModalityDTO: Int,
        lastModification: String = String()
    ) {
        viewModelScope.launch {
            uiStateExercise.value = LocalStoreStatus.Loading()
            val exercise = ExerciseDTO(
                id = id,
                name = name,
                weight = weight,
                reps = reps,
                notes = notes,
                muscleGroupId = muscleGroupId,
                idModalityDTO = idModalityDTO,
                lastModification = lastModification
            )
            uiStateExercise.value = exerciseRepository.insertExercise(exercise)
        }

    }


}