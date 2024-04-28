package com.juanferdev.feature.listexercises.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.juanferdev.feature.addmusclegroup.ui.theme.MyGymEvolutionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExercisesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGymEvolutionTheme {

            }
        }
    }
}