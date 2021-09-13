package ru.geekbrains.lesson_1314_3_1_main.api

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomBottomNavigationView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr:Int=0)
    : BottomNavigationView(context,attr,defStyleAttr){

    val MAX_ITEM_COUNT = 10
}