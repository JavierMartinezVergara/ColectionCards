package com.javiermtz.colectioncards.presentation.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.javiermtz.colectioncards.databinding.FragmentFavoritesBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.userscreen.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var itemTouchHelper: ItemTouchHelper
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var adapterFavorites: FavoritesCardsRecyclerView

    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapterFavorites = FavoritesCardsRecyclerView { card ->
            deleteCard(card)
        }

        setAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.userFlow.collect { user ->
                        adapterFavorites.submitList(user.listCards.toList())
                    }
                }
            }
        }
    }

    private fun setAdapter() {
        binding.favsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.favsRecycler.adapter = adapterFavorites
        val swipe = SwipeRecyclerFavorites(
            itemListener = adapterFavorites
        )
        itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(binding.favsRecycler)

    }

    private fun deleteCard(item: CardsDTO) {
        viewModel.deleteFavorite(item)
    }
}
