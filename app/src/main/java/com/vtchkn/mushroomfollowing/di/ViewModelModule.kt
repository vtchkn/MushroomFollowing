package com.vtchkn.mushroomfollowing.di

import com.vtchkn.mushroomfollowing.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val viewModelModule = module {
    viewModel {
        MainViewModel(
            mushroomFollowingRepository = get(),
            additivesRepository = get(),
            measurementsRepository = get(),
            substratesRepository = get(),
            stagesRepository = get()
        )
    }
}