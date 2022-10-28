package com.javiermtz.colectioncards.presentation.cardscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.CardsItemBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.favorites.ItemListener

class CardsAdapter(
    private val navToDetail: (CardsDTO) -> Unit,
    private val addFavorite: (CardsDTO) -> Unit
) :
    ListAdapter<CardsDTO, CardsAdapterViewHolder>(DiffUtilItemCards), ItemListener {

    companion object DiffUtilItemCards : DiffUtil.ItemCallback<CardsDTO>() {
        override fun areItemsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onItemSwipe(position: Int) {
        addFavorite(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CardsAdapterViewHolder(layoutInflater.inflate(R.layout.cards_item, parent, false))
    }

    override fun onBindViewHolder(holder: CardsAdapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, navToDetail)
    }
}

class CardsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}
