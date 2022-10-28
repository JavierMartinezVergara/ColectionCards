package com.javiermtz.colectioncards.domain.models

data class User(
    val id: Int = 0,
    val name: String = "",
    var listCards: Set<CardsDTO> = setOf()
)
