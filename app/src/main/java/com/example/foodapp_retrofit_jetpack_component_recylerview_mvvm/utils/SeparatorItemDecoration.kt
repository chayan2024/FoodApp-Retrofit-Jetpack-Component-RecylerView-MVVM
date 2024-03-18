package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SeparatorItemDecoration(context: Context, resId: Int) : RecyclerView.ItemDecoration() {

    private var separator: Drawable? = null

    init {
        separator = ContextCompat.getDrawable(context, resId)
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + separator!!.intrinsicHeight
            separator!!.setBounds(left, top, right, bottom)
            separator!!.draw(canvas)
        }
    }
}
