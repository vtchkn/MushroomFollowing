package com.vtchkn.mushroomfollowing.data.model

data class Measurement(val name: String? = null) {
    fun type(): Type {
            return when (name) {
                Type.GRAM.value -> Type.GRAM
                Type.MILLILITER.value -> Type.MILLILITER
                else -> Type.MILLILITER
            }
        }

    enum class Type(val value: String) {
        GRAM("gram"),
        MILLILITER("milliliter")
    }

}