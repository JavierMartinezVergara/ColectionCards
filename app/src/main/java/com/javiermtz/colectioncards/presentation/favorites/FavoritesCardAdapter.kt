package com.javiermtz.colectioncards.presentation.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.CardsItemBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO

class FavoritesCardsRecyclerView(
    private val onClickListener: (CardsDTO) -> Unit,
) :
    ListAdapter<CardsDTO, FavoritesCardsAdapterViewHolder>(DiffUtilItem), ItemListener {

    companion object DiffUtilItem : DiffUtil.ItemCallback<CardsDTO>() {
        override fun areItemsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoritesCardsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoritesCardsAdapterViewHolder(
            layoutInflater.inflate(
                R.layout.cards_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoritesCardsAdapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClickListener)
    }

    override fun onItemSwipe(position: Int) {
        onClickListener(getItem(position))
    }
}

class FavoritesCardsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
        }
    }
}
