package com.javiermtz.colectioncards.domain.models

import androidx.annotation.DrawableRes

data class CardsDTO(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes
    val image: Int
)
