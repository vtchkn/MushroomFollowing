package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Stage
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.StageVD
import com.vtchkn.mushroomfollowing.viewdata.parseTimeStamp

class StageVDMapper(
    private val deathReasonVDMapper: DeathReasonVDMapper,
    private val contaminationVDMapper: ContaminationVDMapper,
) : Mapper<StageVD, Stage>() {
    override fun executeMapping(type: Stage?): StageVD? {
        return type?.run {
            StageVD(
                _id = _id,
                name = name,
                description = description,
                type = type(this.type),
                lifetime = lifetime?.parseTimeStamp(),
                creationDate = creationDate?.parseTimeStamp(),
                deathTime = deathTime?.parseTimeStamp(),
                deathReasonVD = deathReasonVDMapper.executeMapping(deathReason),
                contaminationVDS = contamination?.mapNotNull {
                    contaminationVDMapper.executeMapping(
                        it
                    )
                }
            )
        }
    }

    fun type(type: String?): StageVD.Type {
        return when (type) {
            StageVD.Type.INOCULATION.value -> StageVD.Type.INOCULATION
            StageVD.Type.INCUBATION.value -> StageVD.Type.INCUBATION
            StageVD.Type.FRUCTIFICATION.value -> StageVD.Type.FRUCTIFICATION
            StageVD.Type.CASING.value -> StageVD.Type.CASING
            StageVD.Type.FRUITING.value -> StageVD.Type.FRUITING
            StageVD.Type.HARVEST.value -> StageVD.Type.HARVEST
            StageVD.Type.DUNK.value -> StageVD.Type.DUNK

            else -> StageVD.Type.INOCULATION
        }
    }

}
