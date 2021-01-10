package com.vtchkn.mushroomfollowing.viewdata

import java.util.*

data class StageVD(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: Type? = null,
    val lifetime: Date? = null,
    val creationDate: Date? = null,
    val deathTime: Date? = null,
    val deathReasonVD: DeathReasonVD? = null,
    val contaminationVD: List<ContaminationVD>? = null
) {

    fun type(type: String): Type {
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
