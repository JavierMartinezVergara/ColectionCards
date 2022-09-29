package com.javiermtz.colectioncards.presentation.cardscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.javiermtz.colectioncards.databinding.FragmentCardsBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private val viewModel: CardsViewModel by viewModels()
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
                viewModel.cards.collectLatest { cards ->
                    recyclerViewSet(cards)
                }
            }
        }
    }

    private fun recyclerViewSet(cardList: List<CardsDTO>) {
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        adapter = CardsRecyclerView(cardList)
        binding.recyclerViewCards.adapter = adapter
    }

    companion object {
        @JvmStatic fun newInstance() =
            CardsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
