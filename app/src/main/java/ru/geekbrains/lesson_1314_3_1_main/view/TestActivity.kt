package ru.geekbrains.lesson_1314_3_1_main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.LinearInterpolator
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivitySplashBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityTestBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentMainBinding
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment
import ru.geekbrains.lesson_1314_3_1_main.view.settings.SettingsFragment
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener

class TestActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val themeID = getMyTheme();
        setTheme(themeID)*/
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val builder = GuideView.Builder(this)
            .setTitle("ВНИМАНИЕ! ПЛОХОЙ ПОДХОД")
            .setContentText("Здесь мы выделили ВАЖНУЮ кнопку размером текста, так лучше не делать")
            .setGravity(Gravity.center)
            .setDismissType(DismissType.selfView)
            .setTargetView(binding.btnTestBad)
            .setDismissType(DismissType.anywhere)
            .setGuideListener(object : GuideListener {
                override fun onDismiss(view: View?) {
                    val builder = GuideView.Builder(this@TestActivity)
                        .setTitle("ВНИМАНИЕ! ПРАВИЛЬНЫЙ ПОДХОД")
                        .setContentText("Здесь мы выделили ВАЖНУЮ кнопку стилем OutlinedButton, это хорошая практика")
                        .setGravity(Gravity.center)
                        .setDismissType(DismissType.selfView)
                        .setTargetView(binding.btnTestGood)
                        .setDismissType(DismissType.anywhere)
                        .setGuideListener(object : GuideListener {
                            override fun onDismiss(view: View?) {

                            }
                        })
                    builder.build().show()
                }
            })
        builder.build().show()


    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}