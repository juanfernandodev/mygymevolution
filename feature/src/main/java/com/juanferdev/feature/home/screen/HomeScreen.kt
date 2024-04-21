package com.juanferdev.feature.home.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juanferdev.core.data.musclegroup.models.MuscleGroupModel
import com.juanferdev.core.data.musclegroup.repositories.LocalStoreStatus
import com.juanferdev.feature.features.home.TopLevelDestination
import com.juanferdev.feature.features.musclegroups.stateholder.MuscleGroupsViewModel
import com.juanferdev.feature.features.settings.screen.SettingsScreen
import com.juanferdev.feature.musclegroups.screen.MuscleGroupsScreen


@Composable
fun HomeScreen(
    muscleGroupsViewModel: MuscleGroupsViewModel,
    goToAddMuscleGroup: () -> Unit
) {

    val localStoreMuscleGroups = muscleGroupsViewModel.uiState.value

    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navHostController) }
    ) { paddingValues ->
        HomeNavHost(
            navHostController = navHostController,
            paddingValues = paddingValues,
            localStoreStatus = localStoreMuscleGroups,
            goToAddMuscleGroup = goToAddMuscleGroup
        )

    }

}

@Composable
private fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val items = listOf(TopLevelDestination.HOME, TopLevelDestination.SETTINGS)
    NavigationBar(modifier = modifier.fillMaxWidth()) {
        items.forEachIndexed { _, item ->
            val selected = getCurrentRoute(navController) == item.titleText
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.titleText) },
                icon = { Icon(item.icon, contentDescription = item.titleText) },
                label = { Text(item.titleText) }
            )
        }
    }
}


@Composable
fun HomeNavHost(
    localStoreStatus: LocalStoreStatus<List<MuscleGroupModel>>,
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    goToAddMuscleGroup: () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = TopLevelDestination.HOME.titleText,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = TopLevelDestination.HOME.titleText) {
            MuscleGroupsScreen(localStoreStatus, goToAddMuscleGroup = goToAddMuscleGroup)
        }
        composable(route = TopLevelDestination.SETTINGS.titleText) {
            SettingsScreen()
        }
    }
}

@Composable
private fun getCurrentRoute(navController: NavHostController) =
    navController.currentBackStackEntryAsState().value?.destination?.route ?: String()


