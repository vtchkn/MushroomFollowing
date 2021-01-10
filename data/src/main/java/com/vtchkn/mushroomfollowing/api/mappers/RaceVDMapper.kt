package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Race
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.RaceVD

class RaceVDMapper : Mapper<RaceVD?, Race?>() {
    override fun executeMapping(type: Race?): RaceVD? {
        return type?.run {
            RaceVD(_id, name, description)
        }
    }

}
