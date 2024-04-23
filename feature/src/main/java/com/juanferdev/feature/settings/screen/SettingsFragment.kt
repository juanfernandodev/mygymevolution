package com.juanferdev.feature.settings.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SettingsScreen(
    listModality: List<String> = listOf(
        "pesas",
        "mancuernas",
        "barra",
        "Discos",
        "Otro",
        "Otro"
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        val modalityToAdd = remember { mutableStateOf(String()) }
        Text(
            "Administrate your app",
            modifier = Modifier
                .padding(bottom = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            OutlinedTextField(
                modifier = Modifier.weight(0.5f),
                value = modalityToAdd.value,
                onValueChange = { newValue -> modalityToAdd.value = newValue },
                placeholder = { Text(text = "Add exercise modalities") }
            )
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Outlined.Add, contentDescription = "Localized description")
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 3),
            horizontalArrangement = Arrangement.Center
        ) {
            items(listModality) {
                InputChipExample(it)
            }

        }


    }
}


@Composable
fun InputChipExample(
    text: String
) {
    Surface(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
    ) {
        InputChip(
            onClick = {},
            label = { Text(text) },
            selected = true,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        )
    }
}

