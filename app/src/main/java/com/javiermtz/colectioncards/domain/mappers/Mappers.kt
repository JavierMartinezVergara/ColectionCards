package com.javiermtz.colectioncards.domain.mappers

import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.localdata.models.Cards

fun List<Cards>.toCardsDTO(): List<CardsDTO> {
    val mutableList: MutableList<CardsDTO> = mutableListOf()
    for (cards in this) {
        mutableList.add(cards.toCardDTO())
    }
    return mutableList
}

fun Cards.toCardDTO(): CardsDTO {
    return CardsDTO(
        id = id,
        name = name,
        description = description,
        image = image,
        power = oddity
    )
}
