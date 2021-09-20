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
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*

import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsEnlargeBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsExplodeBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsPathTransitionsBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsShuffleBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsShuffleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsShuffleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles:MutableList<String> = ArrayList()
        for(i in 0..4){
            titles.add("Item $i")
        }
        binding.button.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,ChangeBounds())
            binding.transitionsContainer.removeAllViews()
            titles.shuffle()
            for(title in titles){
                binding.transitionsContainer.addView(TextView(this).apply {
                    text= title
                    ViewCompat.setTransitionName(this,title)
                    gravity = Gravity.CENTER_HORIZONTAL
                })
            }
        }
    }


}