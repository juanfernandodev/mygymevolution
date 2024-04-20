package com.juanferdev.feature.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.juanferdev.feature.features.home.screen.HomeScreen
import com.juanferdev.feature.features.home.ui.theme.MyGymEvolutionTheme
import com.juanferdev.feature.features.musclegroups.stateholder.MuscleGroupsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val muscleGroupsViewModel: MuscleGroupsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGymEvolutionTheme {
                HomeScreen(muscleGroupsViewModel)
            }
        }
    }
}