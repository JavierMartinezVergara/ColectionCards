package com.javiermtz.colectioncards.presentation.cardscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.javiermtz.colectioncards.databinding.FragmentCardsBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.ListType
import com.javiermtz.colectioncards.presentation.ListType.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private val viewModel: CardsViewModel by activityViewModels()
    private lateinit var binding: FragmentCardsBinding
    lateinit var adapter: CardsRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getCards()
        binding = FragmentCardsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.cards.collectLatest { cards ->
                        recyclerViewSet(cards)
                    }
                }
                launch {
                    viewModel.typeRecycler.collect { type ->
                        changeLayoutManager(type)
                    }
                }
            }
        }
    }

    private fun changeLayoutManager(type: ListType) {
        when (type) {
            List -> binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
            Grid -> binding.recyclerViewCards.layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

    private fun recyclerViewSet(cardList: List<CardsDTO>) {
        adapter = CardsRecyclerView(cardList) {
            onClickItem(it)
        }
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onClickItem(cardsDTO: CardsDTO) {
        val actionCard = CardsFragmentDirections.navCardsToDetail(cardsDTO)
        findNavController().navigate(actionCard)
    }

    companion object {
        @JvmStatic fun newInstance() =
            CardsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
