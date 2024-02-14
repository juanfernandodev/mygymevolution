package com.juanferdev.mygymevolution.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val titleText: String,
    val icon: ImageVector
) {
    HOME(titleText = "Muscle Group", Icons.Filled.Home),
    SETTINGS(titleText = "Settings", Icons.Filled.Settings)
}