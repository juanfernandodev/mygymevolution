package com.juanferdev.feature.features.musclegroups.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.juanferdev.feature.features.musclegroups.stateholder.MuscleGroupsViewModel


@Composable
fun MuscleGroupsScreen(muscleGroupViewModel: MuscleGroupsViewModel = viewModel()) {
    val muscleGroups = muscleGroupViewModel.uiState.value
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            items(muscleGroups) { muscleGroup ->
                BoxMuscleGroup(
                    muscleGroup, modifier = Modifier
                        .height(255.dp)
                        .width(206.dp)
                )
            }
        }
    }
}

@Composable
private fun BoxMuscleGroup(muscle: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.White)
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
