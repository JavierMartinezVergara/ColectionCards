package com.javiermtz.localdata

import com.javiermtz.localdata.models.Cards
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getCards(): Flow<List<Cards>>
}
