package com.example.scrollbar.extenssions

import androidx.recyclerview.widget.RecyclerView

//fun RecyclerView.handleScroll(itemScrollerBinding: ItemScrollerBinding) {
//    post {
//        val parentWidth = itemScrollerBinding.parent.width
//        val layoutParams = itemScrollerBinding.progress.layoutParams
//        val initialX = itemScrollerBinding.progress.x
//        layoutManager?.let {
//            val totalWidth = this.computeHorizontalScrollRange()
//            val visibleWidth = this.computeHorizontalScrollExtent()
//            val percent =
//                visibleWidth.toFloat() / totalWidth.toFloat()
//            layoutParams.width = (parentWidth * percent).toInt()
//            itemScrollerBinding.progress.layoutParams = layoutParams
//            addOnScrollListener(object :
//                RecyclerView.OnScrollListener() {
//
//                override fun onScrolled(
//                    recyclerView: RecyclerView,
//                    dx: Int,
//                    dy: Int,
//                ) {
//                    super.onScrolled(recyclerView, dx, dy)
//                    val scrolledWidth =
//                        this@handleScroll.computeHorizontalScrollOffset()
//                    val updatedVisibleWidthRecyclerView =
//                        visibleWidth + scrolledWidth
//                    val scrolledWidthScroller =
//                        ((parentWidth.toFloat() / totalWidth) * scrolledWidth)
//                    itemScrollerBinding.progress.x =
//                        initialX + scrolledWidthScroller
//                }
//            })
//        }
//    }
//}