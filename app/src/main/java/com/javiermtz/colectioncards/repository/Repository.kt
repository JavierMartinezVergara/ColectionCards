package com.javiermtz.colectioncards.repository

import com.javiermtz.localdata.models.Cards
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getCards(): Flow<List<Cards>>
}
