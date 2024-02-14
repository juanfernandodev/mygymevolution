package com.juanferdev.feature.features.addmusclegroup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.juanferdev.feature.features.addmusclegroup.stateholder.AddMuscleGroupViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMuscleGroupScreen(addMuscleGroupViewModel: AddMuscleGroupViewModel = viewModel()) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = "",
                onValueChange = { /* TODO */ },
                label = { Text("Name Muscle Group") },
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
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(bottom = 24.dp)) {
                Text("Save")
            }
        }

    }
}
