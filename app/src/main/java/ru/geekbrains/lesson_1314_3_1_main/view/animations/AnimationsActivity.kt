package ru.geekbrains.lesson_1314_3_1_main.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.transition.Transition
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*

import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsEnlargeBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsExplodeBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsPathTransitionsBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsPathTransitionsBinding

    var isRightAnimation = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsPathTransitionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            isRightAnimation= !isRightAnimation
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = 2000
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,changeBounds)

            val params =  binding.button.layoutParams as FrameLayout.LayoutParams
            if(isRightAnimation){
                params.gravity = Gravity.END or Gravity.BOTTOM
            }else{
                params.gravity = Gravity.TOP or Gravity.START
            }
            binding.button.layoutParams = params

        }
    }


}