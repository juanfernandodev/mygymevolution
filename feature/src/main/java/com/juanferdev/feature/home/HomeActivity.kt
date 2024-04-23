package com.juanferdev.feature.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.juanferdev.feature.addmusclegroup.AddMuscleGroupActivity
import com.juanferdev.feature.features.home.ui.theme.MyGymEvolutionTheme
import com.juanferdev.feature.features.musclegroups.stateholder.MuscleGroupsViewModel
import com.juanferdev.feature.home.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val muscleGroupsViewModel: MuscleGroupsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGymEvolutionTheme {
                HomeScreen(
                    muscleGroupsViewModel,
                    goToAddMuscleGroup = ::goToAddMuscleGroup
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        muscleGroupsViewModel.getListMuscleGroup()
    }

    private fun goToAddMuscleGroup() {
        startActivity(Intent(this, AddMuscleGroupActivity::class.java))
    }
}