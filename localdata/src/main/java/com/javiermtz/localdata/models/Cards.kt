package com.javiermtz.localdata.models

import androidx.annotation.DrawableRes

data class Cards(
    val id: Int,
    val name: String,
    @DrawableRes
    val image: Int,
    val oddity: Int,
    val description: String,
    val category: String

)
