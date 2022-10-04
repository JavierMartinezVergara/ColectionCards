package com.javiermtz.colectioncards.presentation.userscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javiermtz.colectioncards.domain.GetUserUseCase
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(val getUserUseCase: GetUserUseCase) : ViewModel() {

    var user = getUserUseCase.invoke()

    private val _userFlow = MutableSharedFlow<User>(replay = 2)
    val userFlow = _userFlow.asSharedFlow()

    fun getUSer() {
        viewModelScope.launch {
            _userFlow.emit(user)
        }
    }

    fun setCardtoUser(card: CardsDTO, isBuy: Boolean) {
        viewModelScope.launch {
            val list = user.listCards
            if (isBuy) {
                list.add(card)
            } else {
                list.remove(card)
            }
            user = user.copy(
                listCards = list
            )
            _userFlow.emit(
                user
            )
        }
    }

    fun hasCard(card: CardsDTO): Boolean {
        return user.listCards.contains(card)
    }
}
