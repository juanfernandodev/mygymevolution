package com.juanferdev.core.data.musclegroup.mapper

import com.juanferdev.core.data.musclegroup.dto.MuscleGroupDTO
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel

class MuscleGroupMapper {

    fun mapperMuscleGroupModelToMuscleGroupDTO(muscleGroupModel: MuscleGroupModel) =
        MuscleGroupDTO(
            id = muscleGroupModel.id,
            name = muscleGroupModel.name
        )

    fun mapperListMuscleGroupModelToListMuscleGroupDTO(listMuscleGroupModel: List<MuscleGroupModel>): List<MuscleGroupDTO> {
        return listMuscleGroupModel.map {
            mapperMuscleGroupModelToMuscleGroupDTO(it)
        }
    }
}