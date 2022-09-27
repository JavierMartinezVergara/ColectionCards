package com.javiermtz.colectioncards.repository

import com.javiermtz.localdata.LocalDataSource
import com.javiermtz.localdata.models.Cards
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {

    override fun getCards(): Flow<List<Cards>> {
        return localDataSource.getCards()
    }
}
