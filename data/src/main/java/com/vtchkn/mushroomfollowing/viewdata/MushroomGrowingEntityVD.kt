package com.vtchkn.mushroomfollowing.viewdata

import java.util.*

data class MushroomGrowingEntityVD(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val raceVD: RaceVD? = null,
    val bases: List<SubstrateVD>? = null,
    val stageVD: StageVD? = null,
    val sizeVD: SizeVD? = null,
    val creationDate: Date? = null,
    val additiveVDS: List<AdditiveVD>? = null,
    val substratesVDS: List<SubstrateVD>? = null,
    val originVD: OriginVD? = null,
    val lifetime: Date? = null,
    val flushVDS: List<FlushVD>? = null,
    val deathTime: Date? = null,
    val deathReasonVD: DeathReasonVD? = null
) {
}

