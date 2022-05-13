package empower.ca.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import empower.ca.R


class IndicatorView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(
    context, attrs, defStyleAttr
) {
    private var imageViews: Array<ImageView?>? = null

    fun setRecyclerView(
        recyclerView: RecyclerView?,
        layoutManager: LinearLayoutManager?,
        itemCountList: Int,
        itemLast: Int,
        isDarkThemeOn: Boolean
    ) {
        val itemCountManager = layoutManager?.itemCount ?: 0
        if (itemCountManager < 1) {
            return
        }

        val pageIndicatorActiveDrawable =
            AppCompatResources.getDrawable(context, R.drawable.indicator_selected_state)
        val pageIndicatorInactiveDrawable =
            AppCompatResources.getDrawable(context, R.drawable.indicator_default_state)

        // Set index of last item to be one less if it exceeds number of items
        val itemLastObj = if (itemCountList == itemLast) {
            itemLast - 1
        } else {
            itemLast
        }

        // If content count is 1 or less then do not show page indicator else show.
        if (itemCountList > 1) {
            createPageControl(
                itemCountList,
                itemLastObj,
                pageIndicatorActiveDrawable,
                pageIndicatorInactiveDrawable
            )
        } else {
            removeAllViews()
        }

        // Switch dots as the RecyclerView scrolls
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val position = if (layoutManager?.findFirstCompletelyVisibleItemPosition() != -1) {
                    layoutManager?.findFirstCompletelyVisibleItemPosition()
                } else {
                    layoutManager.findLastVisibleItemPosition()
                }

                itemCountList.let {
                    imageViews?.let { imageViewsObj ->
                        if (it == imageViewsObj.size)
                            for (i in 0 until it) {
                                imageViewsObj[i]?.setImageDrawable(pageIndicatorInactiveDrawable)
                            }
                    }
                }

                position?.let {
                    imageViews?.get(it)?.setImageDrawable(pageIndicatorActiveDrawable)
                }
            }
        })
    }

    private fun createPageControl(
        itemCount: Int, selectedIndex: Int = 0, pageIndicatorActive: Drawable?,
        pageIndicatorInactive: Drawable?
    ) {
        imageViews = arrayOfNulls(itemCount)
        var selectedIndexObj = 0
        if (selectedIndex != -1) {
            selectedIndexObj = selectedIndex
        }

        // Reset all views
        removeAllViews()
        imageViews?.let {
            for (i in 0 until itemCount) {
                it[i] = ImageView(context)
                it[i]?.setImageDrawable(pageIndicatorInactive)
                val dotSize = resources.getDimensionPixelSize(R.dimen.indicator_dot_size)
                val params = LayoutParams(dotSize, dotSize)
                params.setMargins(dotSize / 2, 0, dotSize / 2, 0)
                it[i]?.layoutParams = params
                addView(it[i])
            }
            it[selectedIndexObj]?.setImageDrawable(pageIndicatorActive)
        }
    }
}