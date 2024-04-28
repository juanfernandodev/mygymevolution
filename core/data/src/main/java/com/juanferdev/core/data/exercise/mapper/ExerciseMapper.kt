package com.juanferdev.core.data.exercise.mapper

import com.juanferdev.core.data.exercise.dto.ExerciseDTO
import com.juanferdev.core.data.exercise.models.ExerciseModel

class ExerciseMapper {

    fun mapperExerciseModelToExerciseDTO(
        exerciseModel: ExerciseModel
    ): ExerciseDTO {
        return ExerciseDTO(
            id = exerciseModel.id,
            name = exerciseModel.name,
            muscleGroupId = exerciseModel.id,
            idModalityDTO = exerciseModel.idModalityDTO
        )
    }

    fun mapperExerciseModelListToExerciseDTOList(
        exerciseModelList: List<ExerciseModel>
    ): List<ExerciseDTO> {
        return exerciseModelList.map { exerciseModel ->
            mapperExerciseModelToExerciseDTO(
                exerciseModel = exerciseModel
            )
        }
    }

    fun mapperExerciseDTOToExerciseModel(
        exerciseDTO: ExerciseDTO
    ): ExerciseModel {
        return ExerciseModel(
            id = exerciseDTO.id,
            idModalityDTO = exerciseDTO.idModalityDTO,
            muscleGroupId = exerciseDTO.muscleGroupId,
            name = exerciseDTO.name
        )
    }
}