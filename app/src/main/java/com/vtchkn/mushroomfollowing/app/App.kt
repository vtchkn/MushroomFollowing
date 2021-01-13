package com.vtchkn.mushroomfollowing.app

import android.app.Application
import com.vtchkn.mushroomfollowing.di.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.context.startKoin

class App : Application() {
    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare modules
            modules(
                listOf(
                    dbModule,
                    mappersModule,
                    useCasesModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}
