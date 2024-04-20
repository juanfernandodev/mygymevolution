package com.juanferdev.mygymevolution

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanferdev.feature.features.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, HomeActivity::class.java))
    }
}


