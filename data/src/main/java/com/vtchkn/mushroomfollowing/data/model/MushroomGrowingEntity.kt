package com.vtchkn.mushroomfollowing.repository.model

data class MushroomGrowingEntity(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val race: Race? = null,
    val bases: List<Substrate>? = null,
    val stage: Stage? = null,
    val size: Size? = null,
    val creationDate: Date? = null,
    val additives: List<Additive>? = null,
    val substrates: List<Substrate>? = null,
    val origin: Origin? = null,
    val lifetime: Date? = null,
    val flushes: List<Flush>? = null,
    val deathTime: Date? = null,
    val deathReason: DeathReason? = null
) {
}

