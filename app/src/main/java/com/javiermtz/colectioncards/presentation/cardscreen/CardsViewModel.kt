package com.javiermtz.colectioncards.presentation.cardscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javiermtz.colectioncards.domain.UseCases
import com.javiermtz.colectioncards.domain.models.CardsDTO
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

    fun getCards() {
        viewModelScope.launch {
            useCases.getCardsUseCase.invoke().collect {
                _cards.value = it
            }
        }
    }
}
