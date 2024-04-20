package com.juanferdev.feature.features.musclegroups.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.feature.R
import com.juanferdev.feature.features.composables.ErrorDialog
import com.juanferdev.feature.features.composables.LoadingWheel


@Composable
fun MuscleGroupsScreen(localStoreStatus: LocalStoreStatus<List<MuscleGroupModel>>) {
    when (localStoreStatus) {
        is LocalStoreStatus.Error ->
            ErrorDialog(
                errorMessageId = R.string.there_was_error
            ) {}

        is LocalStoreStatus.Loading -> LoadingWheel()
        is LocalStoreStatus.Success -> {
            val listMuscleGroup = localStoreStatus.data
            if (listMuscleGroup.isNotEmpty()) {
                BoxMuscleGroupList(localStoreStatus.data)
            } else {
                ErrorDialog(
                    errorMessageId = R.string.there_are_not_muscle_group
                ) { //Todo: go to add muscle group
                }
            }

        }
    }
}

@Composable
private fun BoxMuscleGroupList(muscleGroupList: List<MuscleGroupModel>) {
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
            AddMuscleGroupFAB(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 10.dp, bottom = 20.dp)
            ) {}
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
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Check mark",
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )
        Text(
            muscle,
            fontSize = 16.sp,
            modifier = modifier.wrapContentHeight(Alignment.Bottom)
        )
    }
}

@Composable
fun AddMuscleGroupFAB(modifier: Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Create, "Button to add new muscle group.")
    }
}

@Preview
@Composable
fun Preview() {

    val muscleGroupList = listOf(
        MuscleGroupModel(id = 1, name = "Quadriceps"),
        MuscleGroupModel(id = 1, name = "Adductors"),
        MuscleGroupModel(id = 1, name = "Femoral"),
        MuscleGroupModel(id = 1, name = "Gluteus"),
        MuscleGroupModel(id = 1, name = "Triceps"),
        MuscleGroupModel(id = 1, name = "Biceps")
    )

    BoxMuscleGroupList(muscleGroupList)
}
