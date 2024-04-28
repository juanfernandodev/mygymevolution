package com.juanferdev.feature.musclegroups.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanferdev.core.data.musclegroup.dto.MuscleGroupDTO
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.feature.R
import com.juanferdev.feature.composables.ErrorDialog
import com.juanferdev.feature.composables.FloatingActionButton
import com.juanferdev.feature.features.composables.LoadingWheel


@Composable
fun MuscleGroupsScreen(
    localStoreStatus: LocalStoreStatus<List<MuscleGroupDTO>>,
    goToAddMuscleGroup: () -> Unit
) {


    when (localStoreStatus) {
        is LocalStoreStatus.Error ->
            ErrorDialog(
                errorMessageId = R.string.there_was_error
            ) {}

        is LocalStoreStatus.Loading -> LoadingWheel()
        is LocalStoreStatus.Success -> {
            val listMuscleGroup = localStoreStatus.data
            if (listMuscleGroup.isNotEmpty()) {
                BoxMuscleGroupList(
                    localStoreStatus.data,
                    goToAddMuscleGroup = goToAddMuscleGroup
                )
            } else {
                ErrorDialog(
                    errorMessageId = R.string.there_are_not_muscle_group,
                    onDialogDismiss = goToAddMuscleGroup
                )
            }

        }

        is LocalStoreStatus.Completed -> {
            //All is completed
        }
    }
}

@Composable
private fun BoxMuscleGroupList(
    muscleGroupList: List<MuscleGroupDTO>,
    goToAddMuscleGroup: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                items(muscleGroupList) { muscleGroup ->
                    BoxMuscleGroup(
                        muscleGroup.name, modifier = Modifier
                            .height(255.dp)
                            .width(206.dp)
                    )
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 10.dp, bottom = 20.dp),
                icon = Icons.Filled.Create,
                contentDescriptionId = R.string.button_to_add_new_muscle_group
            ) {
                goToAddMuscleGroup()
            }


        }

    }
}

@Composable
private fun BoxMuscleGroup(muscle: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.background)
            .clickable { }
    ) {
        Text(
            muscle,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun Preview() {

    val muscleGroupList = listOf(
        MuscleGroupDTO(id = 1, name = "Quadriceps"),
        MuscleGroupDTO(id = 1, name = "Adductors"),
        MuscleGroupDTO(id = 1, name = "Femoral"),
        MuscleGroupDTO(id = 1, name = "Gluteus"),
        MuscleGroupDTO(id = 1, name = "Triceps"),
        MuscleGroupDTO(id = 1, name = "Biceps")
    )

    BoxMuscleGroupList(muscleGroupList) {}
}
