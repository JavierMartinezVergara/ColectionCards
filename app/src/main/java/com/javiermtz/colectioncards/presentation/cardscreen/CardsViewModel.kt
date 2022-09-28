package com.javiermtz.colectioncards.presentation.cardscreen

import androidx.lifecycle.ViewModel
import com.javiermtz.colectioncards.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(useCases: UseCases) : ViewModel() {

    val getAllcards = useCases.getCardsUseCase.invoke()
}
