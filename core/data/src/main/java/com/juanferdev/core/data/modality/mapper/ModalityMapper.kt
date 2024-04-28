package com.juanferdev.core.data.modality.mapper

import com.juanferdev.core.data.modality.dto.ModalityDTO
import com.juanferdev.core.data.modality.models.ModalityModel

class ModalityMapper {

    fun mapperModalityModelListToModalityDTOList(
        modalityModelList: List<ModalityModel>
    ): List<ModalityDTO> {
        return modalityModelList.map { modalityModel ->
            mapperModalityModelToModalityDTO(modalityModel)
        }
    }

    fun mapperModalityModelToModalityDTO(modalityModel: ModalityModel): ModalityDTO {
        return ModalityDTO(
            id = modalityModel.id,
            name = modalityModel.name
        )
    }
}