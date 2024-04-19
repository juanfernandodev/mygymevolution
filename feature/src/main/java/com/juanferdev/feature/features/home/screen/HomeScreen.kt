package com.juanferdev.feature.features.home.screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juanferdev.feature.features.home.TopLevelDestination
import com.juanferdev.feature.features.musclegroups.screen.MuscleGroupsScreen
import com.juanferdev.feature.features.settings.screen.SettingsScreen

@Preview
@Composable
fun HomeScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navHostController) }
    ) { paddingValues ->
        HomeNavHost(
            navHostController = navHostController,
            paddingValues = paddingValues
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
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = TopLevelDestination.HOME.titleText,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = TopLevelDestination.HOME.titleText) {
            MuscleGroupsScreen()
        }
        composable(route = TopLevelDestination.SETTINGS.titleText) {
            SettingsScreen()
        }
    }
}

@Composable
private fun getCurrentRoute(navController: NavHostController) =
    navController.currentBackStackEntryAsState().value?.destination?.route ?: String()


