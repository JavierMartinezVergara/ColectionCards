package com.javiermtz.colectioncards.presentation.detailcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.javiermtz.colectioncards.databinding.FragmentDetailCardBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCardFragment : Fragment() {

    private lateinit var binding: FragmentDetailCardBinding

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
    }

    private fun setView(card: CardsDTO) {
        binding.imageCard.setImageResource(card.image)
        binding.cardName.text = card.name
        binding.cardDetails.text = card.description
    }
}
