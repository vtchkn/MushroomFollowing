package com.vtchkn.mushroomfollowing.app

import android.app.Application
import com.vtchkn.mushroomfollowing.di.dbModule
import com.vtchkn.mushroomfollowing.di.mappersModule
import com.vtchkn.mushroomfollowing.di.repositoryModule
import com.vtchkn.mushroomfollowing.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.context.startKoin

class App : Application() {
    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare modules
            modules(listOf(dbModule, mappersModule, repositoryModule, viewModelModule))
        }
    }
}
