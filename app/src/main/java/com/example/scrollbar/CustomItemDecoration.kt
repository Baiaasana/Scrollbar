package com.example.scrollbar

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecoration( private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        // Set margin for all items except the first and last
        if (position > 0 && position < itemCount - 1) {
            outRect.left = margin
        }

        // Set margin for the first item
        if (position == 0) {
            outRect.left = margin * 2
        }

        // Set margin for the last item
        if (position == itemCount - 1) {
            outRect.right = margin * 2
            outRect.left = margin
        }
    }
}