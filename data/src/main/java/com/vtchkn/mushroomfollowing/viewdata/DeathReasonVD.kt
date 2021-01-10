package com.vtchkn.mushroomfollowing.viewdata


data class DeathReasonVD(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: Type? = null,

) {


    enum class Type(val value: String) {
        CONTAMINATION("contamination"),
        NATURAL("natural"),
        ENVIRONMENT("environment")
    }

}