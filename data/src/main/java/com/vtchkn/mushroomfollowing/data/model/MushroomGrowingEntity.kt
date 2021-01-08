package com.vtchkn.mushroomfollowing.data.model

import com.vtchkn.mushroomfollowing.repository.model.Origin
import com.vtchkn.mushroomfollowing.repository.model.Substrate

data class MushroomGrowingEntity(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val race: Race? = null,
    val bases: List<Substrate>? = null,
    val stage: Stage? = null,
    val size: Size? = null,
    val creationDate: Long? = null,
    val additives: List<Additive>? = null,
    val substrates: List<Substrate>? = null,
    val origin: Origin? = null,
    val lifetime: Long? = null,
    val flushes: List<Flush>? = null,
    val deathTime: Long? = null,
    val deathReason: DeathReason? = null
) {
}

