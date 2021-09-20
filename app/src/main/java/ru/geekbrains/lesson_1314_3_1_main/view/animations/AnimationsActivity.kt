package ru.geekbrains.lesson_1314_3_1_main.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.transition.Transition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*

import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsEnlargeBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsExplodeBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsEnlargeBinding

    var isExpanded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsEnlargeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnClickListener {
            isExpanded= !isExpanded

            val set = TransitionSet()
                .addTransition(ChangeBounds())
                .addTransition(ChangeImageTransform())

            TransitionManager.beginDelayedTransition(binding.container,set)
            binding.imageView.scaleType = if(isExpanded){
                ImageView.ScaleType.CENTER_CROP
            }else{
                ImageView.ScaleType.FIT_CENTER
            }
        }
    }


}