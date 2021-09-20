package ru.geekbrains.lesson_1314_3_1_main.view.animations

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Fade
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsBinding

    private var textIsVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            //TransitionManager.beginDelayedTransition(binding.transitionsContainer)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,Slide(Gravity.TOP))
            textIsVisible = !textIsVisible
            //binding.text.visibility = if(textIsVisible) View.VISIBLE else View.GONE
        }
    }
}