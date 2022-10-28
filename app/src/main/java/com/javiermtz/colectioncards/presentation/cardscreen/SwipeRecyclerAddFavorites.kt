package com.javiermtz.colectioncards.presentation.cardscreen

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.javiermtz.colectioncards.presentation.favorites.ItemListener
import javax.inject.Inject

class SwipeRecyclerAddFavorites @Inject constructor(
    private val itemListener: ItemListener
) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
        return makeMovementFlags(0, ItemTouchHelper.RIGHT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: ViewHolder,
        target: ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        itemListener.onItemSwipe(viewHolder.adapterPosition)
    }
}
