package com.juanferdev.core.data.modality.repositories

import com.juanferdev.core.data.database.calls.makeLocalStoreCall
import com.juanferdev.core.data.modality.datastores.ModalityDao
import com.juanferdev.core.data.modality.dto.ModalityDTO
import com.juanferdev.core.data.modality.mapper.ModalityMapper
import com.juanferdev.core.data.modality.models.ModalityModel
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ModalityRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val modalityDao: ModalityDao
) {

    fun getAllModalities(): Flow<LocalStoreStatus<List<ModalityDTO>>> {
        return flow {
            modalityDao.getAllModalities().collect {
                val listModalityDTO = ModalityMapper().mapperModalityModelListToModalityDTOList(it)
                emit(LocalStoreStatus.Success(listModalityDTO))
            }
        }.flowOn(dispatcher)
    }

    suspend fun saveModality(name: String): LocalStoreStatus<Any> {
        return makeLocalStoreCall(dispatcher) {
            val modalityModel = ModalityModel(name = name)
            modalityDao.insertModality(modalityModel)
        }
    }
}