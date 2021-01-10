package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Substrate
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.SubstrateVD
import com.vtchkn.mushroomfollowing.viewdata.parseTimeStamp

class SubstrateVDMapper(private val sizeVDMapper: SizeVDMapper) :
    Mapper<SubstrateVD?, Substrate?>() {
    override fun executeMapping(type: Substrate?): SubstrateVD? {
        return type?.run {
            SubstrateVD(
                _id = _id,
                name = name,
                description = description,
                size = sizeVDMapper.executeMapping(size),
                creationDate = creationDate?.parseTimeStamp()
            )
        }
    }

}
