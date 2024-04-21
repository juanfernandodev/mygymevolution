package com.juanferdev.feature.addmusclegroup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.juanferdev.feature.R
import com.juanferdev.feature.addmusclegroup.screen.AddMuscleGroupScreen
import com.juanferdev.feature.addmusclegroup.stateholder.AddMuscleGroupViewModel
import com.juanferdev.feature.addmusclegroup.ui.theme.MyGymEvolutionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMuscleGroupActivity : ComponentActivity() {

    private val addMuscleGroupViewModel: AddMuscleGroupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGymEvolutionTheme {
                AddMuscleGroupScreen(
                    addMuscleGroupViewModel,
                    onSuccess = ::finishActivity
                )
            }
        }
    }

    private fun finishActivity() {
        Toast.makeText(this, getString(R.string.muscle_group_saved), Toast.LENGTH_LONG).show()
        finish()
    }
}
