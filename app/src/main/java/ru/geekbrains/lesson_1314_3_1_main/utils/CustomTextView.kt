package ru.geekbrains.lesson_1314_3_1_main.utils

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr:Int=0)
    :AppCompatTextView(context,attr,defStyleAttr){

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("mylogs","work ${(1..1000).random()}")
    }
}