package com.javiermtz.colectioncards.presentation.detailcard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.FragmentDetailCardBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.utils.LifeCycleHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCardFragment : Fragment() {

    companion object {
        private val CARDKEY = "card"
    }

    private val lifecycleHelper: LifeCycleHelper = LifeCycleHelper(this.javaClass.canonicalName ?: "")
    private lateinit var binding: FragmentDetailCardBinding
    private lateinit var card: CardsDTO

    private val safeArgs: DetailCardFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            restoreCard(savedInstanceState)
        }
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
        card = safeArgs.card
        setView(card)
    }

    private fun setView(card: CardsDTO) {
        binding.imageCard.setImageResource(card.image)
        binding.cardName.text = card.name
        binding.cardDetails.text = card.description
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(CARDKEY, card)
    }

    private fun restoreCard(savedInstanceState: Bundle) {
        card = savedInstanceState.getParcelable(CARDKEY) ?: CardsDTO(image = R.drawable.image_not_found)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        card = CardsDTO(image = R.drawable.image_not_found)
    }

    override fun onDestroy() {
        super.onDestroy()
        card = CardsDTO(image = R.drawable.image_not_found)
    }
}
