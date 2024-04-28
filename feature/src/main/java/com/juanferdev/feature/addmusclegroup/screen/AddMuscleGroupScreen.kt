package com.juanferdev.feature.addmusclegroup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.feature.R
import com.juanferdev.feature.addmusclegroup.stateholder.AddMuscleGroupViewModel
import com.juanferdev.feature.composables.ErrorDialog
import com.juanferdev.feature.features.composables.LoadingWheel
import com.juanferdev.feature.features.home.ui.theme.MyGymEvolutionTheme


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
        is LocalStoreStatus.Completed -> {
            //All is completed
        }
    }
}

@Composable
fun RegisterMuscleGroup(
    onClickSave: (nameMuscleGroup: String) -> Unit
) {
    val nameMuscleGroup = remember { mutableStateOf(String()) }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameMuscleGroup.value,
            onValueChange = { newValue ->
                nameMuscleGroup.value = newValue
            },
            label = { Text(stringResource(R.string.name_muscle_group)) },
            modifier = Modifier
                .heightIn(56.dp)
                .padding(bottom = 24.dp)
        )
        OutlinedButton(
            onClick = { onClickSave(nameMuscleGroup.value) },
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(stringResource(R.string.save))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MyGymEvolutionTheme {
        RegisterMuscleGroup {}
    }

}
