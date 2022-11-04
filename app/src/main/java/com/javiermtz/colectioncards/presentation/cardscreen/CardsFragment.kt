package com.javiermtz.colectioncards.presentation.cardscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.javiermtz.colectioncards.databinding.FragmentCardsBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.ListType
import com.javiermtz.colectioncards.presentation.ListType.*
import com.javiermtz.colectioncards.presentation.ShowBottom.Hide
import com.javiermtz.colectioncards.presentation.userscreen.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private val viewModel: CardsViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentCardsBinding
    lateinit var adapter: CardsAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

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
        recyclerViewSet()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.cards.collectLatest { cards ->
                        adapter.submitList(cards)
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

    private fun recyclerViewSet() {
        adapter = CardsAdapter(
            {
                navToDetail(it)
            },
            {
                Toast.makeText(
                    requireContext(),
                    "Se ha añadido la card ${it.name} a favoritos",
                    Toast.LENGTH_LONG
                ).show()
                userViewModel.addFavoriteCard(it)
            }
        )
        binding.recyclerViewCards.adapter = adapter
        val swipe = SwipeRecyclerAddFavorites(
            itemListener = adapter
        )
        itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(binding.recyclerViewCards)
    }

    private fun navToDetail(cardsDTO: CardsDTO) {
        val actionCard = CardsFragmentDirections.navCardsToDetail(cardsDTO)
        findNavController().navigate(actionCard)
        viewModel.showBottonNav(Hide)
    }
}
