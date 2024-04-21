package com.juanferdev.feature.addmusclegroup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.feature.R
import com.juanferdev.feature.addmusclegroup.stateholder.AddMuscleGroupViewModel
import com.juanferdev.feature.composables.ErrorDialog
import com.juanferdev.feature.features.composables.LoadingWheel


@Composable
fun AddMuscleGroupScreen(
    addMuscleGroupViewModel: AddMuscleGroupViewModel,
    onSuccess: () -> Unit
) {
    val uiStatus = addMuscleGroupViewModel.uiState.value
    RegisterMuscleGroup { muscleGroup ->
        addMuscleGroupViewModel.addMuscleGroup(muscleGroup)
    }

    when (uiStatus) {
        is LocalStoreStatus.Error -> ErrorDialog(errorMessageId = uiStatus.messageId) { }
        is LocalStoreStatus.Loading -> LoadingWheel()
        is LocalStoreStatus.Success -> onSuccess()
        null -> addMuscleGroupViewModel.resetUiState()
    }
}

@Composable
fun RegisterMuscleGroup(
    onClickSave: (nameMuscleGroup: String) -> Unit
) {
    val nameMuscleGroup = remember { mutableStateOf(String()) }
    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nameMuscleGroup.value,
            onValueChange = { newValue ->
                nameMuscleGroup.value = newValue
            },
            label = { Text(stringResource(R.string.name_muscle_group)) },
            modifier = Modifier
                .heightIn(56.dp)
                .padding(bottom = 24.dp)
        )
        Text(
            "Select icon:",
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 24.dp)
        )
        Button(
            onClick = { }, modifier = Modifier
                .padding(bottom = 24.dp)
                .width(128.dp)
                .height(128.dp)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
        OutlinedButton(
            onClick = { onClickSave(nameMuscleGroup.value) },
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(stringResource(R.string.save))
        }
    }
}
