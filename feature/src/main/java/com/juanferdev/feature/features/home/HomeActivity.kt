package com.juanferdev.feature.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.juanferdev.feature.features.home.screen.HomeScreen
import com.juanferdev.feature.features.home.ui.theme.MyGymEvolutionTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGymEvolutionTheme {
                HomeScreen()
            }
        }
    }
}