package com.javiermtz.colectioncards.presentation.detailcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.javiermtz.colectioncards.databinding.FragmentDetailCardBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.ShowBottom.Hide
import com.javiermtz.colectioncards.presentation.cardscreen.CardsViewModel
import com.javiermtz.colectioncards.presentation.userscreen.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCardFragment : Fragment() {

    private lateinit var binding: FragmentDetailCardBinding

    private val userViewModel: UserViewModel by activityViewModels()
    private val safeArgs: DetailCardFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val card = safeArgs.card
        setView(card)
        binding.isBuy.setOnCheckedChangeListener { _, isChecked ->
            userViewModel.setCardtoUser(card, isChecked)
        }
    }

    private fun setView(card: CardsDTO) {
        binding.imageCard.setImageResource(card.image)
        binding.cardName.text = card.name
        binding.cardDetails.text = card.description
        binding.isBuy.isChecked = userViewModel.hasCard(card)
    }
}
