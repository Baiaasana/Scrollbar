package com.example.scrollbar.my_components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.internal.ContextUtils.getActivity


@SuppressLint("RestrictedApi")
class BoldTextView(context: Context, attrs: AttributeSet?) :
    AppCompatTextView(context, attrs) {
    init { val tfBold = Typeface.createFromAsset(context.assets, "fonts/fira_go_bold.ttf")
        this.typeface = tfBold
        this.includeFontPadding = false
    }

}