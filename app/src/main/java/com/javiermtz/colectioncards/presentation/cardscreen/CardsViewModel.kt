package com.javiermtz.colectioncards.presentation.cardscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javiermtz.colectioncards.domain.UseCases
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.ListType
import com.javiermtz.colectioncards.presentation.ShowBottom
import com.javiermtz.colectioncards.presentation.ShowBottom.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(val useCases: UseCases) : ViewModel() {

    private val _cards = MutableStateFlow<List<CardsDTO>>(emptyList())
    val cards: StateFlow<List<CardsDTO>> = _cards

    private val _showBottonNav = MutableStateFlow<ShowBottom>(Show)
    val showBottonNav: StateFlow<ShowBottom> = _showBottonNav

    private val _typeRecycler = MutableStateFlow<ListType>(ListType.List)
    val typeRecycler: StateFlow<ListType> = _typeRecycler

    fun getCards() {
        viewModelScope.launch {
            useCases.getCardsUseCase.invoke().collect {
                _cards.value = it
            }
        }
    }

    fun setState(type: ListType) {
        viewModelScope.launch {
            _typeRecycler.value = type
        }
    }

    fun showBottonNav(isShow: ShowBottom) {
        viewModelScope.launch {
            _showBottonNav.value = isShow
        }
    }
}
