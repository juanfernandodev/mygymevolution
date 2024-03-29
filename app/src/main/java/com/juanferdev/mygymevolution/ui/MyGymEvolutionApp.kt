package com.juanferdev.mygymevolution.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juanferdev.mygymevolution.navigation.MyGymEvolutionNavHost
import com.juanferdev.mygymevolution.navigation.TopLevelDestination

@Composable
fun MyGymEvolutionApp(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        MyGymEvolutionNavHost(navController, innerPadding)

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
private fun getCurrentRoute(navController: NavHostController) =
    navController.currentBackStackEntryAsState().value?.destination?.route ?: String()
