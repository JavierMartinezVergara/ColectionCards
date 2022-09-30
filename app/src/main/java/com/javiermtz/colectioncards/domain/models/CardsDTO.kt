package com.javiermtz.colectioncards.domain.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardsDTO(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes
    val image: Int
) : Parcelable
