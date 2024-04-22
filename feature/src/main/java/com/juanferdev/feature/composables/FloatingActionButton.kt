package com.juanferdev.feature.composables

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@Composable
fun FloatingActionButton(
    modifier: Modifier,
    icon: ImageVector,
    contentDescriptionId: Int,
    onClick: () -> Unit,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Icon(icon, stringResource(contentDescriptionId))
    }
}
