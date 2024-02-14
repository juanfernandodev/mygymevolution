package com.juanferdev.core.data.database

import android.app.Application

class AppDatabaseApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.instance(this) }
}