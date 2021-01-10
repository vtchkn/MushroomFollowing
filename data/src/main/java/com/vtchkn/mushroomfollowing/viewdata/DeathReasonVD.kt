package com.vtchkn.mushroomfollowing.viewdata


data class DeathReasonVD(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: Type? = null,

) {
    fun type(type: String): Type {
        return when (type) {
            Type.CONTAMINATION.value -> Type.CONTAMINATION
            Type.NATURAL.value -> Type.NATURAL
            Type.ENVIRONMENT.value -> Type.ENVIRONMENT
            else -> Type.CONTAMINATION
        }
    }

    enum class Type(val value: String) {
        CONTAMINATION("contamination"),
        NATURAL("natural"),
        ENVIRONMENT("environment")
    }

}