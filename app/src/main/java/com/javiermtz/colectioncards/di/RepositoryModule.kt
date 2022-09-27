package com.javiermtz.colectioncards.di

import com.javiermtz.colectioncards.repository.Repository
import com.javiermtz.colectioncards.repository.RepositoryImpl
import com.javiermtz.localdata.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Provides
  @Singleton
  fun localDataSource(localDataSource : LocalDataSource) : Repository {
    return RepositoryImpl(localDataSource = localDataSource)
  }
}
