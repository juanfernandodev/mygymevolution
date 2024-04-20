package com.juanferdev.core.data.musclegroup.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class MuscleGroupModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NotNull @ColumnInfo("name") val name: String,
    @ColumnInfo("image") val image: String = String(),
    @NotNull @ColumnInfo("lastModification") val lastModification: String = String()
)
