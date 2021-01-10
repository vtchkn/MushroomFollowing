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
    val contaminationVDS: List<ContaminationVD>? = null
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
