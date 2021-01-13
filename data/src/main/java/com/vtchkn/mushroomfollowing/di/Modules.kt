package com.vtchkn.mushroomfollowing.di

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger
import com.vtchkn.mushroomfollowing.api.mappers.*
import com.vtchkn.mushroomfollowing.api.usecases.*
import com.vtchkn.mushroomfollowing.repository.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

val dbModule = module {
    single { FirebaseDatabase.getInstance().apply { setLogLevel(Logger.Level.DEBUG) } }
}
val mappersModule = module {
    single { RaceVDMapper() }
    single { DeathReasonVDMapper() }
    single { MeasurementVDMapper() }
    single { ContaminationVDMapper() }
    single { SizeVDMapper(measurementVDMapper = get()) }
    single { ProductionResultVDMapper(sizeVDMapper = get()) }
    single { SubstrateVDMapper(sizeVDMapper = get()) }
    single { StageVDMapper(deathReasonVDMapper = get(), contaminationVDMapper = get()) }
    single { AdditiveVDMapper(sizeVDMapper = get()) }
    single { OriginVDMapper(sizeVDMapper = get()) }
    single { FlushVDMapper(productionResultVDMapper = get()) }
    single {
        MushroomGrowingEntityVDMapper(
            raceVDMapper = get(),
            substrateVDMapper = get(),
            stageVDMapper = get(),
            sizeVDMapper = get(),
            additiveVDMapper = get(),
            originVDMapper = get(),
            flushVDMapper = get(),
            deathReasonVDMapper = get()
        )
    }
}

val useCasesModule = module {
    single { GetMushroomEntitiesUseCase(database = get(), mushroomGrowingEntityVDMapper = get()) }
    single { GetMeasurementsUseCase(database = get(), measurementVDMapper = get()) }
    single { GetAdditivesUseCase(database = get(), addVDMapper = get()) }
    single { GetSubstratesUseCase(database = get(), substrateVDMapper = get()) }
    single { GetStagesUseCase(database = get(), stageVDMapper = get()) }

}

@ExperimentalCoroutinesApi
val repositoryModule = module {
    single { MushroomFollowingRepository(getMushroomEntitiesUseCase = get()) }
    single { MeasurementsRepository(getMeasurementsUseCase = get()) }
    single { AdditivesRepository(getAdditivesUseCase = get()) }
    single { SubstratesRepository(getSubstratesUseCase = get()) }
    single { StagesRepository(getStagesUseCase = get()) }
}