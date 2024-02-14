package com.juanferdev.mygymevolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.juanferdev.mygymevolution.ui.MyGymEvolutionApp
import com.juanferdev.mygymevolution.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyGymEvolutionApp()
            }
        }
    }
}


