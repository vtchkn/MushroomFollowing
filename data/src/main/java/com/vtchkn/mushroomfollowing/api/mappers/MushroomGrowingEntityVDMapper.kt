package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.MushroomGrowingEntityVD
import com.vtchkn.mushroomfollowing.viewdata.parseTimeStamp

class MushroomGrowingEntityVDMapper(
    private val raceVDMapper: RaceVDMapper?,
    private val substrateVDMapper: SubstrateVDMapper?,
    private val stageVDMapper: StageVDMapper,
    private val sizeVDMapper: SizeVDMapper,
    private val additiveVDMapper: AdditiveVDMapper,
    private val originVDMapper: OriginVDMapper,
    private val flushVDMapper: FlushVDMapper,
    private val deathReasonVDMapper: DeathReasonVDMapper
) :
    Mapper<MushroomGrowingEntityVD, MushroomGrowingEntity>() {
    override fun executeMapping(type: MushroomGrowingEntity?): MushroomGrowingEntityVD? {
        return type?.run {
            MushroomGrowingEntityVD(
                _id = _id,
                name = name,
                description = description,
                raceVD = raceVDMapper?.executeMapping(race),
                bases = bases?.mapNotNull { substrateVDMapper?.executeMapping(it) },
                stageVD = stageVDMapper.executeMapping(stage),
                sizeVD = sizeVDMapper.executeMapping(size),
                creationDate = creationDate?.parseTimeStamp(),
                additiveVDS = additives?.mapNotNull { additiveVDMapper.executeMapping(it) },
                substratesVDS = substrates?.mapNotNull { substrateVDMapper?.executeMapping(it) },
                originVD = originVDMapper.executeMapping(origin),
                lifetime = lifetime?.parseTimeStamp(),
                flushVDS = flushes?.mapNotNull { flushVDMapper.executeMapping(it) },
                deathTime = deathTime?.parseTimeStamp(),
                deathReasonVD = deathReasonVDMapper.executeMapping(deathReason)
            )
        }
    }
}