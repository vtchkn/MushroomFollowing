package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.DeathReason
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.DeathReasonVD

class DeathReasonVDMapper : Mapper<DeathReasonVD?, DeathReason?>() {
    override fun executeMapping(type: DeathReason?): DeathReasonVD? {
        return type?.run {
            DeathReasonVD(
                _id = _id,
                name = name,
                description = description,
                type = type(this.type)
            )
        }
    }

    fun type(type: String?): DeathReasonVD.Type {
        return when (type) {
            DeathReasonVD.Type.CONTAMINATION.value -> DeathReasonVD.Type.CONTAMINATION
            DeathReasonVD.Type.NATURAL.value -> DeathReasonVD.Type.NATURAL
            DeathReasonVD.Type.ENVIRONMENT.value -> DeathReasonVD.Type.ENVIRONMENT
            else -> DeathReasonVD.Type.CONTAMINATION
        }
    }

}
