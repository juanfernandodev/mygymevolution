package com.juanferdev.feature.listexercises.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juanferdev.core.data.exercise.dto.ExerciseDTO


val exercisesList = listOf(
    ExerciseDTO(
        id = 0,
        name = "Pull Over",
        notes = "Aquí van las notas",
        muscleGroupId = 1,
        idModalityDTO = 1
    ),
    ExerciseDTO(
        id = 0,
        name = "Banco Plano",
        notes = "Este ejercicio consiste en esto",
        muscleGroupId = 1,
        idModalityDTO = 1
    ),
    ExerciseDTO(
        id = 0,
        name = "Pull Over",
        muscleGroupId = 1,
        idModalityDTO = 1,
        notes = "El ejercicio equivale a esto"
    )
)

@Preview(showBackground = true)
@Composable
fun ListExercises() {
    LazyColumn {
        items(exercisesList) { exerciseDTO ->
            ExerciseCard(exerciseDTO)
        }
    }
}

@Composable
fun ExerciseCard(exercise: ExerciseDTO) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 24.dp, horizontal = 8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .weight(0.8F),
                    text = exercise.name,
                    textAlign = TextAlign.Center
                )
                Icon(
                    imageVector = Icons.Filled.AttachFile,
                    contentDescription = "Ver opciones",
                )
            }
            Icon(
                imageVector = Icons.Filled.Image,
                contentDescription = "Imagen del ejercicio",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
            Text(
                text = "Weight: ${exercise.weight}Lb"
            )

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = exercise.notes
            )
        }
    }
}