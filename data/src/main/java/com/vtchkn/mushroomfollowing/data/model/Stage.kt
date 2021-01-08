package com.vtchkn.mushroomfollowing.data.model

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

    fun type(): Stage.Type {
        return when (type) {
            Type.INOCULATION.value -> Type.INOCULATION
            Type.INCUBATION.value -> Type.INCUBATION
            Type.FRUCTIFICATION.value -> Type.FRUCTIFICATION
            Type.CASING.value -> Type.CASING
            Type.FRUITING.value -> Type.FRUITING
            Type.HARVEST.value -> Type.HARVEST
            Type.DUNK.value -> Type.DUNK

            else -> Type.INOCULATION
        }
    }

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
