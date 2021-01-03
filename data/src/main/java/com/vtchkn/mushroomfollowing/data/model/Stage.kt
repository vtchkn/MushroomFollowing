package com.vtchkn.mushroomfollowing.repository.model

data class Stage(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: Type? = null,
    val lifetime: Date? = null,
    val creationDate: Date? = null,
    val deathTime: Date? = null,
    val deathReason: DeathReason? = null,
    val contamination: List<Contamination>? = null
) {

    enum class Type(val value: String) {
        INOCULATION("inoculation"),
        INCUBATION("incubation"),
        FRUCTIFICATION("fructification"),
        CASING("casing"),
        FRUITING("fruiting"),
        HARVEST("harvest"),
        DUNK("dunk")
    }

}
