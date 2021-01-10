package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Contamination
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.ContaminationVD

class ContaminationVDMapper : Mapper<ContaminationVD, Contamination>() {
    override fun executeMapping(type: Contamination?): ContaminationVD? {
        return type?.run {
            ContaminationVD(
                _id = _id,
                name = name,
                description = description,
                isConsumed = isConsumed,
                type = type(this.type)
            )
        }
    }

    fun type(type: String?): ContaminationVD.Type {
        return when (type) {
            ContaminationVD.Type.BACTERIA.value -> ContaminationVD.Type.BACTERIA
            ContaminationVD.Type.MUSHROOM.value -> ContaminationVD.Type.MUSHROOM
            else -> ContaminationVD.Type.BACTERIA
        }
    }
}
