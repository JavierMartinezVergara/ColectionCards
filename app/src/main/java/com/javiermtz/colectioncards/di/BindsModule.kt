package com.javiermtz.colectioncards.di

import com.javiermtz.colectioncards.presentation.cardscreen.CardsAdapter
import com.javiermtz.colectioncards.presentation.favorites.FavoritesCardsRecyclerView
import com.javiermtz.colectioncards.presentation.favorites.ItemListener
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Module {

    @Binds
    abstract fun bindFavoritesRecycler(favoritesCard: FavoritesCardsRecyclerView): ItemListener

    @Binds
    abstract fun bindCardsRecycler(cardsAdapter: CardsAdapter): ItemListener
}

