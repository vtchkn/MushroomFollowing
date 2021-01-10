package com.vtchkn.mushroomfollowing.api.model

data class Stage(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: String? = null,
    val lifetime: Long? = null,
    val creationDate: Long? = null,
    val deathTime: Long? = null,
    val deathReason: DeathReason? = null,
    val contamination: List<Contamination>? = null
) {


}
