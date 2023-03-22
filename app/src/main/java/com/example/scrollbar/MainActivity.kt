package com.example.scrollbar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollbar.data.ServiceModel
import com.example.scrollbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val serviceAdapter: ServiceAdapter = ServiceAdapter()

    private val services = mutableListOf(
        ServiceModel(0, "ავტომატური გადახდები", R.drawable.statistics),
        ServiceModel(1, "შაბლონები", R.drawable.statistics),
        ServiceModel(2, "სტატისტიკა", R.drawable.statistics),
        ServiceModel(3, "სტატისტიკა", R.drawable.statistics),
        ServiceModel(4, "სტატისტიკა", R.drawable.statistics)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {
        rvServices.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = serviceAdapter
            rvServices.addOnScrollListener(scrollListener)
        }
        serviceAdapter.submitList(services)
        rvServices.addItemDecoration(CustomItemDecoration(resources.getDimensionPixelSize(R.dimen.margin_norm)))
        checkSeekBar()


    }

    private fun checkSeekBar() = with(binding) {
        if (serviceAdapter.currentList.size <= 4) {
            seekBar.visibility = View.INVISIBLE
            seekBarBackground.visibility = View.INVISIBLE
        } else {
            seekBar.visibility = View.VISIBLE
            seekBarBackground.visibility = View.VISIBLE
        }
    }

    private var scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as? LinearLayoutManager ?: return
            val totalItemCount = layoutManager.itemCount
            val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

            if (totalItemCount > 0 && lastVisibleItemPosition >= 0) {
                val scrollX = recyclerView.computeHorizontalScrollOffset()
                val viewWidth = recyclerView.width - recyclerView.paddingStart - recyclerView.paddingEnd
                val scrollPercent = (100 * scrollX) / viewWidth
                binding.seekBar.progress = scrollPercent
            }
        }
    }
}

