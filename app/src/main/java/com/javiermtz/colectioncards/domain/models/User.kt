package com.javiermtz.colectioncards.domain.models

data class User(
    val id: Int,
    val name: String,
    var listCards: List<CardsDTO> = listOf()
)
