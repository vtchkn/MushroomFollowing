package com.vtchkn.mushroomfollowing.di

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.mappers.*
import com.vtchkn.mushroomfollowing.repository.MushroomFollowingRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

val dbModule = module {
    single { FirebaseDatabase.getInstance() }
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

@ExperimentalCoroutinesApi
val repositoryModule = module {
    fun provideMushroomFollowingRepository(
        raceVDMapper: RaceVDMapper?,
        substrateVDMapper: SubstrateVDMapper?,
        stageVDMapper: StageVDMapper,
        sizeVDMapper: SizeVDMapper,
        additiveVDMapper: AdditiveVDMapper,
        originVDMapper: OriginVDMapper,
        flushVDMapper: FlushVDMapper,
        deathReasonVDMapper: DeathReasonVDMapper,
        mushroomGrowingEntityVDMapper: MushroomGrowingEntityVDMapper,
        firebaseDatabase: FirebaseDatabase
    ): MushroomFollowingRepository {
        return MushroomFollowingRepository(
            raceVDMapper,
            substrateVDMapper,
            stageVDMapper,
            sizeVDMapper,
            additiveVDMapper,
            originVDMapper,
            flushVDMapper,
            deathReasonVDMapper,
            mushroomGrowingEntityVDMapper,
            firebaseDatabase
        )
    }
    single {
        provideMushroomFollowingRepository(
            raceVDMapper = get(),
            substrateVDMapper = get(),
            stageVDMapper = get(),
            sizeVDMapper = get(),
            additiveVDMapper = get(),
            originVDMapper = get(),
            flushVDMapper = get(),
            deathReasonVDMapper = get(),
            mushroomGrowingEntityVDMapper = get(),
            firebaseDatabase = get()
        )
    }
}