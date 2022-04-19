package com.example.android.compoundviews.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.android.compoundviews.R

class CustomCounter : LinearLayout {
    constructor(context: Context): super(context){}

    constructor(mContext: Context, attrs: AttributeSet): super(mContext, attrs){}

    constructor(context: Context,
                attrs: AttributeSet,
                defStyleAttr: Int): super(context, attrs, defStyleAttr){}

    constructor(context: Context,
                attrs: AttributeSet,
                defStyleAttr: Int,
                defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes){}

    private var counter = 0

    init {
        val view = LayoutInflater.from(context).inflate(
            R.layout.counter_layout,
            this
        )
        setUpUI(view)
    }

    private fun setUpUI(view: View) {
        view.findViewById<ImageButton>(R.id.ib_minus).setOnClickListener {
            decreaseCounter()
            updateDisplay(view)
        }
        view.findViewById<ImageButton>(R.id.ib_plus).setOnClickListener {
            increaseCounter()
            updateDisplay(view)
        }
    }

    private fun decreaseCounter() {
        if (counter - 1 < 0) counter = 10
        else
            counter--
    }

    private fun increaseCounter() {
        if (counter + 1 > 10) counter = 0
        else
            counter++
    }

    private fun updateDisplay(view: View) {
        view.findViewById<TextView>(R.id.tv_display_count).text = counter.toString()
    }
}