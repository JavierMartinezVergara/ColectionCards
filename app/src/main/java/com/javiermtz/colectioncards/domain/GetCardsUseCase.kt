package com.javiermtz.colectioncards.domain

import com.javiermtz.colectioncards.domain.mappers.toCardsDTO
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCardsUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<List<CardsDTO>> = repository.getCards()
        .map { cards ->
            cards.toCardsDTO()
        }
}
