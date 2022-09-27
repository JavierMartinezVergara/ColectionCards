package com.javiermtz.di

import com.javiermtz.localdata.LocalDataSource
import com.javiermtz.localdata.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun providesLocalDataSource(): LocalDataSource{
        return LocalDataSourceImpl()
    }
}
