package com.example.scrollbar.my_components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MediumTextView(context: Context, attrs: AttributeSet?) :
    AppCompatTextView(context, attrs) {
    init {
        val face = Typeface.createFromAsset(context.assets, "fonts/firago_regular.ttf")
        this.typeface = face
        this.includeFontPadding = false

    }

}