package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.MushroomGrowingEntityVD

class MushroomGrowingEntityVDMapper(
    private val raceVDMapper: RaceVDMapper?,
    private val substrateVDMapper: SubstrateVDMapper?,
    private val stageVDMapper: StageVDMapper
) :
    Mapper<MushroomGrowingEntityVD, MushroomGrowingEntity>() {
    override fun executeMapping(type: MushroomGrowingEntity?): MushroomGrowingEntityVD? {
        return type?.run {
            MushroomGrowingEntityVD(
                _id,
                name,
                description,
                raceVDMapper?.executeMapping(race),
                bases?.mapNotNull { substrateVDMapper?.executeMapping(it) }

            )
        }
    }
}