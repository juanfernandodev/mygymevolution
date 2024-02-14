package com.juanferdev.mygymevolution.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juanferdev.feature.features.musclegroups.screen.MuscleGroupsScreen
import com.juanferdev.feature.features.settings.screen.SettingsScreen

@Composable
fun MyGymEvolutionNavHost(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.HOME.titleText,
        modifier = Modifier.padding(padding)
    ) {
        composable(route = TopLevelDestination.HOME.titleText) {
            MuscleGroupsScreen()
        }
        composable(route = TopLevelDestination.SETTINGS.titleText) {
            SettingsScreen()
        }


    }
}