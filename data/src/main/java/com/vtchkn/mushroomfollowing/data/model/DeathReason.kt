package com.vtchkn.mushroomfollowing.data.model

/**
 * this could be editable in future for users
 */
data class DeathReason(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val type: Type? = null
) {
    enum class Type {
        CONTAMINATION,
        NATURAL,
        ENVIRONMENT
    }

}