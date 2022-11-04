package com.javiermtz.colectioncards.presentation.cardscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.R.layout
import com.javiermtz.colectioncards.databinding.CardsItemPowerDebilBinding
import com.javiermtz.colectioncards.databinding.CardsItemPowerFuerteBinding
import com.javiermtz.colectioncards.databinding.CardsItemPowerMediumBinding
import com.javiermtz.colectioncards.databinding.CardsItemPowerSupremeBinding
import com.javiermtz.colectioncards.databinding.CardsItemPowerXtremeBinding
import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.presentation.favorites.ItemListener

class CardsAdapter(
    private val navToDetail: (CardsDTO) -> Unit,
    private val addFavorite: (CardsDTO) -> Unit
) :
    ListAdapter<CardsDTO, RecyclerView.ViewHolder>(DiffUtilItemCards), ItemListener {

    companion object DiffUtilItemCards : DiffUtil.ItemCallback<CardsDTO>() {
        override fun areItemsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CardsDTO, newItem: CardsDTO): Boolean {
            return oldItem == newItem
        }
    }

    override fun onItemSwipe(position: Int) {
        addFavorite(getItem(position))
        this.notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        when (viewType) {
            OddityType.Debil.value -> {
                return PowerDebilViewHolder(
                    layoutInflater.inflate(
                        R.layout.cards_item_power_debil,
                        parent,
                        false
                    )
                )
            }

            OddityType.Media.value -> {
                return PowerMediumViewHolder(
                    layoutInflater.inflate(
                        layout.cards_item_power_medium,
                        parent,
                        false
                    )
                )
            }
            OddityType.Fuerte.value -> {
                return PowerFuerteViewHolder(
                    layoutInflater.inflate(
                        layout.cards_item_power_fuerte,
                        parent,
                        false
                    )
                )
            }
            OddityType.Extrema.value -> {
                return PowerXtremeViewHolder(
                    layoutInflater.inflate(
                        R.layout.cards_item_power_xtreme,
                        parent,
                        false
                    )
                )
            }

            else -> {
                return PowerSupremeViewHolder(
                    layoutInflater.inflate(
                        layout.cards_item_power_supreme,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (item.power) {
            1 -> (holder as PowerDebilViewHolder).bind(item, navToDetail)
            2 -> (holder as PowerMediumViewHolder).bind(item, navToDetail)
            3 -> (holder as PowerFuerteViewHolder).bind(item, navToDetail)
            4 -> (holder as PowerXtremeViewHolder).bind(item, navToDetail)
            else -> (holder as PowerSupremeViewHolder).bind(item, navToDetail)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).power) {
            1 -> OddityType.Debil.value
            2 -> OddityType.Media.value
            3 -> OddityType.Fuerte.value
            4 -> OddityType.Extrema.value
            else -> OddityType.Suprema.value
        }
    }
}

class PowerXtremeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemPowerXtremeBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}

class PowerDebilViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemPowerDebilBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.tvFuerza.text = "Su fuerza actual de ${card.name} es ${card.power} lo cual es Debil"
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}

class PowerMediumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemPowerMediumBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}

class PowerFuerteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemPowerFuerteBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}

class PowerSupremeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = CardsItemPowerSupremeBinding.bind(view)

    fun bind(card: CardsDTO, onClickListener: (CardsDTO) -> Unit) {
        binding.tvName.text = card.name
        binding.ivImageCard.setImageResource(card.image)
        itemView.setOnClickListener {
            onClickListener(card)
        }
    }
}

enum class OddityType(val value: Int) {
    Debil(1),
    Media(2),
    Fuerte(3),
    Extrema(4),
    Suprema(5)
}
