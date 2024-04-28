package com.juanferdev.core.data.modality.datastores

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.juanferdev.core.data.modality.models.ModalityModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ModalityDao {

    @Query("SELECT * FROM ModalityModel")
    fun getAllModalities(): Flow<List<ModalityModel>>

    @Query("SELECT * FROM ModalityModel WHERE id = :idModality ")
    suspend fun getModality(idModality: Int): ModalityModel

    @Insert
    suspend fun insertModality(modalityModel: ModalityModel)

    @Delete
    suspend fun deleteModality(modalityModel: ModalityModel)
}