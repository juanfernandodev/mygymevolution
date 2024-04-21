package com.juanferdev.feature.features.exercises.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.juanferdev.feature.R


@Composable
fun CardExercise() {
    Card(
        modifier = Modifier
            .height(480.dp)
            .width(412.dp)
    ) {
        Text(
            "Name Exercise",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(72.dp)
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.default_image), contentDescription = null,
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text("Wight: 100Lb.")
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
        }

    }
}
