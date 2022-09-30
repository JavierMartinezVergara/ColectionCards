package com.javiermtz.colectioncards.presentation.cardscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.CardsItemBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO

class CardsRecyclerView(
    var cards: List<CardsDTO>,
    private val onClickListener: (CardsDTO) -> Unit
) :
    RecyclerView.Adapter<CardsAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CardsAdapterViewHolder(layoutInflater.inflate(R.layout.cards_item, parent, false))
    }

    override fun onBindViewHolder(holder: CardsAdapterViewHolder, position: Int) {
        val item = cards[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return cards.size
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
